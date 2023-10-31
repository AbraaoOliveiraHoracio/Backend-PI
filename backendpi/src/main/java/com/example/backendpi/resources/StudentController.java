package com.example.backendpi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.backendpi.dtos.StudentRequest;
import com.example.backendpi.dtos.StudentResponse;
import com.example.backendpi.mappers.StudentMappers;
import com.example.backendpi.services.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getStudents() {

        var Students = this.service.getStudents();
        return ResponseEntity.ok(StudentMappers.toDTOList(Students));

    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponse> getStudents(@PathVariable long id) {

        var Student = this.service.getStudents(id);
        return ResponseEntity.ok(StudentMappers.toDTO(Student));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {

        this.service.deleteStudentById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<StudentResponse> save(@Validated @RequestBody StudentRequest Student) {

        var savedStudent = this.service.save(Student);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.id())
                .toUri();

        return ResponseEntity.created(location).body(savedStudent);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody StudentRequest Student) {

        this.service.update(id, Student);
        return ResponseEntity.ok().build();

    }
    
}
