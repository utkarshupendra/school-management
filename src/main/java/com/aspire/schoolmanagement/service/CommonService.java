package com.aspire.schoolmanagement.service;

import com.aspire.schoolmanagement.enums.UserType;
import com.aspire.schoolmanagement.models.Employee;
import com.aspire.schoolmanagement.models.Student;
import com.aspire.schoolmanagement.models.StudentJPA;
import com.aspire.schoolmanagement.repository.EmployeeRepository;
import com.aspire.schoolmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CommonService {

    //private final StudentService studentService;
    private final EmployeeService employeeService;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public Map<String, Object> createUser(Map<String, Object> user) {
        switch (UserType.valueOf(String.valueOf(user.get("userType")))) {
            case STUDENT:
                // convert map into student

                //Query1

                //Q2 -> x


                //Q3
                StudentJPA student = new StudentJPA(
                        null,
                        String.valueOf(user.get("name")),
                        Long.parseLong(String.valueOf(user.get("contact"))),
                        String.valueOf(user.get("address")),
                        Integer.parseInt(String.valueOf(user.get("grade"))),
                        String.valueOf(user.get("section")).charAt(0),
                        Float.parseFloat(String.valueOf(user.get("percentage")))
                );
                StudentJPA student1 = studentRepository.save(student);
                student1.setPercentage(30);
                studentRepository.save(student1);
                //studentRepository.findById(2L);
                return new HashMap<>();
            //return studentService.save(user);
            case EMPLOYEE:
                // convert map into employee
                return employeeService.save(user);
            default:
                return null;
        }
    }

    public Employee saveEmployee(Employee employee) {
        System.out.println("Saving using 1st project");
        return employeeRepository.save(employee);
    }

    public String updateEmployee(Long id, String newAddress) {
        int changedRows = employeeRepository.updateAddress(id, newAddress);
        return "Updated " + changedRows + " rows";
    }

    //2nd project
    public Employee saveEmployeeOverHTTP(Employee employee) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Calling the 1st project endpoint");
        ResponseEntity<Employee> employeeResponseEntity = restTemplate.postForEntity("http://localhost:18080/user/employee/", employee, Employee.class);
        return employeeResponseEntity.getBody();
    }

    public Employee getEmployeeByID(Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            return emp.get();
        }
        return null;
    }
}
