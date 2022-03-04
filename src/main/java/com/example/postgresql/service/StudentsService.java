package com.example.postgresql.service;

import com.example.postgresql.dto.StudentDto;
import com.example.postgresql.mapper.StudentMapper;
import com.example.postgresql.model.Student;
import com.example.postgresql.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentsService implements StudentsMethods {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto getStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));

//        StudentDto dto = StudentDto.builder()
//                .name(student.getName())
//                .surname(student.getSurname())
//                .age(student.getAge())
//                .address(student.getAddress())
//                .build();

        StudentDto dto = studentMapper.mapToDto(student);
        return dto;
    }

    @Override
    public void updateStudent(Student student) {
        Student data = studentRepository.findById(student.getId()).orElseThrow(() -> new RuntimeException("NO ID"));
        if (student.getName() != null) {
            data.setName(student.getName());
        }
    }
}

//    private Long id  = 5
//    private String name  = Elbrus;
//    private String surname = Mammadov;
//    private int age = 24;
//    private String address = Baki;

//    private Long id = 5;
//    private String name = null;
//    private String surname = null;
//    private int age = 30;
//    private String address = Gence;

