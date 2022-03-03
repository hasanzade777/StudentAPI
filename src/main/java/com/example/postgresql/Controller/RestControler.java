package com.example.postgresql.Controller;

import com.example.postgresql.model.Student;
import com.example.postgresql.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.NoSuchElementException;

@RestController
@EnableAutoConfiguration
@EnableWebMvc
@RequestMapping("/Postgre")
public class RestControler {
    @Autowired
    StudentsService service;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> PostStudent(@RequestBody Student student) {
        service.addStudent(student);
        System.out.println(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> GetId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudent(id));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> DeleteId(@PathVariable Long id) {
        try {
            service.deleteStudent(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            System.out.println("There is no one with this ID");
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
