package com.aspire.schoolmanagement.models;


import com.aspire.schoolmanagement.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class Student extends User implements Comparable<Student> {
    private int grade;
    private char section;

    public Student(String name, Long id, Long contact, String address, int grade, char section) {
        super(name, id, contact, address, UserType.STUDENT);
        this.grade = grade;
        this.section = section;
    }


    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
