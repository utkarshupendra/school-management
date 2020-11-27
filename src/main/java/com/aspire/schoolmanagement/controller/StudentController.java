package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.models.Employee;
import com.aspire.schoolmanagement.models.User;
import com.aspire.schoolmanagement.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "user")
public class StudentController {
    private final CommonService commonService;

    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> createUser(@RequestBody Map<String, Object> user) {
        return commonService.createUser(user);
    }

    @PostMapping(path = "create/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        return user;
    }

    @PostMapping(path = "employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployee(@RequestBody Employee employee) {
        log.info("In the 1st project");
        return commonService.saveEmployee(employee);
    }

    @PutMapping(path = "employee/address")
    public String updateAddress(@RequestParam("id") Long id, @RequestParam("address") String address) {
        return commonService.updateEmployee(id, address);
    }

    //2nd project
    @PostMapping(path = "employee/http", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployeeOveRHTTP(@RequestBody Employee employee) {
        log.info("In the 2nd project");
        return commonService.saveEmployeeOverHTTP(employee);
    }

    @GetMapping(path = "employee/httpget")
    public String createEmployeeOveRHTTPGet() {
        log.info("GET In the 2nd project");
        return "Success";
    }
}
