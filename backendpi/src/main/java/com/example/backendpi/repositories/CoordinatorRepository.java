package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Coordinator;

public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
}
