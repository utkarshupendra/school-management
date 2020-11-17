package com.aspire.schoolmanagement.models;


import com.aspire.schoolmanagement.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends User {
    private int grade;
    private char section;

    public Student(String name, Long id, Long contact, String address, int grade, char section) {
        super(name, id, contact, address, UserType.STUDENT);
        this.grade = grade;
        this.section = section;
    }
}
