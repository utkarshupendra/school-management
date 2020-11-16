package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.models.Student;
import com.aspire.schoolmanagement.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(path = "student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "evaluate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student evaluateStudent(@RequestBody Student student) {
        student.evaluate(95);
        return student;
    }

    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student saveStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
