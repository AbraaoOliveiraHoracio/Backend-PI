package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
