package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
