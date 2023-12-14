// Controlador

package com.example.backendpi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.backendpi.dtos.CourseRequest;
import com.example.backendpi.dtos.CourseResponse;
import com.example.backendpi.mappers.CourseMapper;
import com.example.backendpi.services.CourseService;

@RestController
@CrossOrigin
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourses() {

        var Courses = this.service.getCourses();
        return ResponseEntity.ok(CourseMapper.toDTOList(Courses));

    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponse> getCourses(@PathVariable long id) {

        var Course = this.service.getCourses(id);
        return ResponseEntity.ok(CourseMapper.toDTO(Course));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) {

        this.service.deleteCourseById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<CourseResponse> save(@Validated @RequestBody CourseRequest Course) {

        var savedCourse = this.service.save(Course);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCourse.id())
                .toUri();

        return ResponseEntity.created(location).body(savedCourse);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody CourseRequest Course) {

        this.service.update(id, Course);
        return ResponseEntity.ok().build();

    }
}
