package com.aspire.schoolmanagement.repository;

import com.aspire.schoolmanagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("update Employee set address=:address where employeeID=:id")
    @Modifying
    @Transactional
    int updateAddress(@Param("id") Long id, @Param("address") String address);

    @Query("select e from Employee e where department=:department")
    List<Employee> findEmployeesByDepartment(@Param("department") String department);
}
