package com.example.postgresql.service;

import com.example.postgresql.dto.StudentDto;
import com.example.postgresql.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface StudentsMethods {
        void addStudent(Student student);
        void deleteStudent(Long id);
        StudentDto getStudent(Long id);
        void updateStudent(Student student);
}
