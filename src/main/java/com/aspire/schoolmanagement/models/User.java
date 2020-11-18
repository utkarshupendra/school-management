package com.aspire.schoolmanagement.models;


import com.aspire.schoolmanagement.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private Long studentID;
    private long contact;
    private String address;
    private UserType userType;
}
