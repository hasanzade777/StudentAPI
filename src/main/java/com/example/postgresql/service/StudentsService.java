package com.example.postgresql.service;

import com.example.postgresql.model.Student;
import com.example.postgresql.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentsService implements StudentsMethods {
    private final StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.findById(student.getId()).orElseThrow(() -> new RuntimeException("NO ID"));
        studentRepository.save(student);
    }
}

// api/student/{id} GET
// api/student/{id} DELETE
// api/student POST
// api/student
// api/student GET

