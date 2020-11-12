package com.aspire.schoolmanagement.models;


import com.aspire.schoolmanagement.enums.UserType;

public abstract class User {
    private String name;
    private String id;
    private long contact;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public abstract UserType getUserType();

    /*@Override
    public String toString() {
        return "Name: "+getName() +", ID: "+getId();
    }*/
}
