package com.aspire.schoolmanagement.service;

import com.aspire.schoolmanagement.enums.UserType;
import com.aspire.schoolmanagement.models.Employee;
import com.aspire.schoolmanagement.models.Student;
import com.aspire.schoolmanagement.models.StudentJPA;
import com.aspire.schoolmanagement.repository.EmployeeRepository;
import com.aspire.schoolmanagement.repository.StudentRepository;
import com.aspire.schoolmanagement.util.RunnableExample;
import com.aspire.schoolmanagement.util.ThreadExample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
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
                /*StudentJPA student = new StudentJPA(
                        null,
                        String.valueOf(user.get("name")),
                        Long.parseLong(String.valueOf(user.get("contact"))),
                        String.valueOf(user.get("address")),
                        Integer.parseInt(String.valueOf(user.get("grade"))),
                        String.valueOf(user.get("section")).charAt(0),
                        Float.parseFloat(String.valueOf(user.get("percentage")))
                );*/
                //StudentJPA student1 = studentRepository.save(student);
                //student1.setPercentage(30);
                //studentRepository.save(student1);


                StudentJPA s1 = studentRepository.getOne(2L);
                StudentJPA s2 = studentRepository.getOne(3L);
                StudentJPA s3 = studentRepository.getOne(4L);


                return new HashMap<>();
            //return studentService.save(user);
            case EMPLOYEE:
                // convert map into employee
                return employeeService.save(user);
            default:
                return null;
        }
    }

    public synchronized Employee saveEmployee(Employee employee) {
        log.error("Saving using 1st project");
        return employeeRepository.save(employee);
    }

    public String updateEmployee(Long id, String newAddress) {
        int changedRows = employeeRepository.updateAddress(id, newAddress);
        return "Updated " + changedRows + " rows";
    }

    //2nd project
    public Employee saveEmployeeOverHTTP(Employee employee) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new ConcurrentHashMap<>();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("Inner Thread : Calling the 1st project endpoint");
                ResponseEntity<Employee> employeeResponseEntity = restTemplate.postForEntity("http://localhost:18080/user/employee/", employee, Employee.class);
                log.info("Inner Thread : " + employeeResponseEntity.getBody().toString());
                map.put("ABC","123");
            }
        });
        thread1.start();

        RunnableExample example = new RunnableExample();
        Thread t2 = new Thread(example);
        t2.start();

        ThreadExample example1 = new ThreadExample();
        example1.start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(example);

        log.info("Calling the 1st project endpoint");
        ResponseEntity<Employee> employeeResponseEntity = restTemplate.postForEntity("http://localhost:18080/user/employee/", employee, Employee.class);
        log.info(employeeResponseEntity.getBody().toString());
        log.info(map.get("ABC"));
        return employeeResponseEntity.getBody();
    }

    public Map<String, Object> getEmployeeByID(Long id) {
        employeeRepository.getOne(id);
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            Map<String, Object> map = new HashMap<>();
            map.put("contact", emp.get().getContact());
            map.put("address", emp.get().getAddress());
            return map;
        }

        return null;
    }

    public String getDummyString() {
        String x = "a";
        return x + "b" + "c";
    }
}
