package com.aspire.schoolmanagement.controller;

import com.aspire.schoolmanagement.models.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "student")
public class StudentController {

    @PostMapping(path = "evaluate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student evaluateStudent(@RequestBody Student student) {
        student.evaluate(95);
        return student;
    }
}
