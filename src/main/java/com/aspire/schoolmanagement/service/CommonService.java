package com.aspire.schoolmanagement.service;

import com.aspire.schoolmanagement.enums.UserType;
import com.aspire.schoolmanagement.models.Employee;
import com.aspire.schoolmanagement.models.Student;
import com.aspire.schoolmanagement.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final StudentService studentService;
    private final EmployeeService employeeService;

    public Map<String, Object> createUser(Map<String, Object> user) {
        switch (UserType.valueOf(String.valueOf(user.get("userType")))) {
            case STUDENT:
                // convert map into student
                return studentService.save(user);
            case EMPLOYEE:
                //convert map into employee
                return employeeService.save(user);
            default:
                return null;
        }
    }
}
