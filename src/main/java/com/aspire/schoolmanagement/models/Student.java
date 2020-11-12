package com.aspire.schoolmanagement.models;


import com.aspire.schoolmanagement.enums.UserType;

import java.util.Map;

public class Student extends User {
    private static int passingMarks = 40;
    private int grade;
    private char section;
    private float percentage;
    private Map<String, Integer> marks;

    public Student(String name, String id, long contact, String address, int grade, char section, float percentage, Map<String, Integer> marks) {
        this.setName(name);
        this.setId(id);
        this.setContact(contact);
        this.setAddress(address);
        this.grade = grade;
        this.section = section;
        this.percentage = percentage;
        this.marks = marks;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }

    public void evaluate(int marks) {
        if (marks > passingMarks)
            this.grade++;
    }

    public void evaluate() {
        this.grade++;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(getId());
    }

    @Override
    public boolean equals(Object o) {
        return this.getId().equals(((Student)o).getId());
    }
}
