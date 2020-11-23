package com.aspire.schoolmanagement.repository;

import com.aspire.schoolmanagement.models.StudentJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentJPA, Long> {
}
