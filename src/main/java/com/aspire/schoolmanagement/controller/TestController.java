package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.models.TestService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping(path = "data/{age}")
    public String getFromPV(@PathVariable("age") Integer age) {
        return String.valueOf(age);
    }

    @PostMapping(path = "data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDummyData(@RequestBody Map<String, String> input) {
        String name = input.get("name");
        int age = Integer.parseInt(input.get("age"));
        return testService.toUpperCase(name, age);
    }

    @PutMapping(path = "data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getDummyData1(@RequestBody Map<String, String> input) {
        String name = input.get("name");
        int age = Integer.parseInt(input.get("age"));
        return testService.toUpperCase(name, age);
    }

    @GetMapping(path = "db")
    public List<Map<String, String>> getDataFroDB() {
        return testService.getDataFromDB();
    }
}
