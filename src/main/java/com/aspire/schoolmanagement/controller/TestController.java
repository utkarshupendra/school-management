package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.models.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestController {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(path = "data")
    public String getDummyData(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "age", required = false) Integer age) {
        return testService.toUpperCase(name, age);
    }
}