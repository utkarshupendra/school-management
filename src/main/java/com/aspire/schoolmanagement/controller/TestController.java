package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.db.PstgresData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestController {
    private PstgresData pstgresData;

    public TestController(PstgresData data) {
        this.pstgresData = data;
    }

    @GetMapping(path = "/data/data1")
    public String getData(@RequestParam("name") String name) {
        return pstgresData.getData(name);
    }

    @GetMapping(path = "/data/city")
    public String getCity() {
        return "HYD";
    }
}