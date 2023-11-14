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

import com.example.backendpi.dtos.TeacherRequest;
import com.example.backendpi.dtos.TeacherResponse;
import com.example.backendpi.mappers.TeacherMappers;
import com.example.backendpi.services.TeacherService;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getTeachers() {

        var Teachers = this.service.getTeachers();
        return ResponseEntity.ok(TeacherMappers.toDTOList(Teachers));

    }

    @GetMapping("{id}")
    public ResponseEntity<TeacherResponse> getTeachers(@PathVariable long id) {

        var Teacher = this.service.getTeachers(id);
        return ResponseEntity.ok(TeacherMappers.toDTO(Teacher));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable long id) {

        this.service.deleteTeacherById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<TeacherResponse> save(@Validated @RequestBody TeacherRequest Teacher) {

        var savedTeacher = this.service.save(Teacher);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTeacher.id())
                .toUri();

        return ResponseEntity.created(location).body(savedTeacher);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody TeacherRequest Teacher) {

        this.service.update(id, Teacher);
        return ResponseEntity.ok().build();

    }
    
}