package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Hours;

public interface HoursRepository extends JpaRepository<Hours, Long> {

}
