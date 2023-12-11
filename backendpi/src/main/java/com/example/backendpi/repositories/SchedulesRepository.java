package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.Schedules;

public interface SchedulesRepository extends JpaRepository<Schedules, Long> {

}
