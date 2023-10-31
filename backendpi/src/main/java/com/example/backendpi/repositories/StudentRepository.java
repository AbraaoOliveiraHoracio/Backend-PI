package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
