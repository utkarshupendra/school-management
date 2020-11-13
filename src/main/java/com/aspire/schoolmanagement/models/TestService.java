package com.aspire.schoolmanagement.models;

import com.aspire.schoolmanagement.config.PostgresManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {
    public String toUpperCase(String name, Integer age) {
        return name != null && age != null ? name.toUpperCase() + ": " + age : "Empty Input";
    }

    public List<Map<String, String>> getDataFromDB() {
        Connection connection = PostgresManager.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from school");
            List<Map<String, String>> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, String> result = new HashMap<>();
                result.put("School ID", String.valueOf(resultSet.getObject("schoolID")));
                result.put("Name", String.valueOf(resultSet.getObject("name")));
                result.put("Contact", String.valueOf(resultSet.getObject("contact")));
                result.put("Address", String.valueOf(resultSet.getObject("address")));
                resultList.add(result);
            }
            return resultList;
        } catch (SQLException e) {
            System.err.println("Error getting data from table");
            return null;
        }
    }
}
