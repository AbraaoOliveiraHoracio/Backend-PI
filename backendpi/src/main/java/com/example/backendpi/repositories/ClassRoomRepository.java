package com.example.backendpi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendpi.entities.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

}
