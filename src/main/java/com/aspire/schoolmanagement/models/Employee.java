package com.aspire.schoolmanagement.models;

import com.aspire.schoolmanagement.enums.ContractTenure;
import com.aspire.schoolmanagement.enums.Department;
import com.aspire.schoolmanagement.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends User {
    private float salary;
    private String designation;
    private Department department;
    private ContractTenure contractTenure;

    public Employee(String name, Long id, Long contact, String address, float salary, String designation, Department department, ContractTenure contractTenure) {
        super(name, id, contact, address, UserType.EMPLOYEE);
        this.salary = salary;
        this.designation = designation;
        this.department = department;
        this.contractTenure = contractTenure;
    }
}
