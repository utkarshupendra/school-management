package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.models.User;
import com.aspire.schoolmanagement.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
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
}
