package com.example.backendpi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backendpi.dtos.ClassRoomRequest;
import com.example.backendpi.dtos.ClassRoomResponse;
import com.example.backendpi.entities.ClassRoom;
import com.example.backendpi.mappers.ClassRoomMapper;
import com.example.backendpi.repositories.ClassRoomRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClassRoomService {

    @Autowired
    private ClassRoomRepository repository;

    public List<ClassRoom> getClassRoom() {

        return this.repository.findAll();

    }

    public ClassRoom getClassRoom(long id) {

        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sala não encontrada!"));

    }

    public void deleteClassRoomById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Sala não encontrada!");

        }
    }

    public ClassRoomResponse save(ClassRoomRequest ClassRoom) {

        var entity = this.repository.save(ClassRoomMapper.toEntity(ClassRoom));
        return ClassRoomMapper.toDTO(entity);
    }

    public void update(long id, ClassRoomRequest classRoomRequest) {
        try {
            var optionalClassRoom = this.repository.findById(id);

            if (optionalClassRoom.isPresent()) {
                var existingClassRoom = optionalClassRoom.get();
                existingClassRoom.setType(classRoomRequest.type());
                existingClassRoom.setSize(classRoomRequest.size());
                existingClassRoom.setFloor(classRoomRequest.floor());

                this.repository.save(existingClassRoom);
            } else {
                throw new EntityNotFoundException("Sala não encontrada!");
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Sala não encontrada!");
        }
    }

}
