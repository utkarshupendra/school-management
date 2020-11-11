package com.aspire.schoolmanagement.db;

import org.springframework.stereotype.Service;

@Service
public class PstgresData {
    public String getData(String name) {
        return name.toUpperCase();
    }
}
