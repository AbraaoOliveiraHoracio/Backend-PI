// Serviços

package com.example.backendpi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendpi.dtos.CourseRequest;
import com.example.backendpi.dtos.CourseResponse;
import com.example.backendpi.entities.Course;
import com.example.backendpi.mappers.CourseMapper;
import com.example.backendpi.repositories.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> getCourses() {

        return this.repository.findAll();

    }

    public Course getCourses(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado!"));

    }

    public void deleteCourseById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Curso não encontrado!");

        }
    }

    public CourseResponse save(CourseRequest Course) {

        var entity = this.repository.save(CourseMapper.toEntity(Course));
        return CourseMapper.toDTO(entity);

    }

    public void update(long id, CourseRequest Course) {

        try {
            var updateCourse = this.repository.getReferenceById(id);
            updateCourse.setName(Course.name());
            updateCourse.setSize(Course.size());
            updateCourse.setPeriod(Course.period());
            this.repository.save(updateCourse);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Curso não encontrado!");
        }

    }

}
