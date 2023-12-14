package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

}
