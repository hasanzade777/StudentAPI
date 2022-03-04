package com.example.postgresql.Controller;

import com.example.postgresql.dto.StudentDto;
import com.example.postgresql.model.Student;
import com.example.postgresql.service.StudentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class RestControler {

   private final StudentsService service;

    @PostMapping
    public ResponseEntity<Void> PostStudent(@RequestBody Student student) {
        log.info("Creating student");
        service.addStudent(student);
        log.info("Creating student is successful");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> GetId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> DeleteId(@PathVariable Long id) {
        try {
            service.deleteStudent(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            System.out.println("There is no one with this ID");
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
