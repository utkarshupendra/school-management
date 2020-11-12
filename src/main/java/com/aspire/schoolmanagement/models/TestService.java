package com.aspire.schoolmanagement.models;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    public String toUpperCase(String name, Integer age) {
        return name != null && age != null ? name.toUpperCase() + ": " + age : "Empty Input";
    }
}
