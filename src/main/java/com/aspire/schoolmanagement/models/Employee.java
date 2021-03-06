package com.aspire.schoolmanagement.models;

import com.aspire.schoolmanagement.enums.ContractTenure;
import com.aspire.schoolmanagement.enums.Department;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;
    private Long contact;
    private String address;
    private Float salary;
    private String designation;
    private String department;
    private String contracttenure;
}
