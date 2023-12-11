// Controlador

package com.example.backendpi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.backendpi.dtos.ClassRoomRequest;
import com.example.backendpi.dtos.ClassRoomResponse;
import com.example.backendpi.mappers.ClassRoomMapper;
import com.example.backendpi.services.ClassRoomService;

@RestController
@CrossOrigin
@RequestMapping("classroom")
public class ClassRoomController {

    @Autowired
    private ClassRoomService service;

    @GetMapping
    public ResponseEntity<List<ClassRoomResponse>> getClassRooms() {

        var ClassRooms = this.service.getClassRoom();
        return ResponseEntity.ok(ClassRoomMapper.toDTOList(ClassRooms));

    }

    @GetMapping("{id}")
    public ResponseEntity<ClassRoomResponse> getClassRooms(@PathVariable long id) {

        var ClassRoom = this.service.getClassRoom(id);
        return ResponseEntity.ok(ClassRoomMapper.toDTO(ClassRoom));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClassRoom(@PathVariable long id) {

        this.service.deleteClassRoomById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<ClassRoomResponse> save(@Validated @RequestBody ClassRoomRequest ClassRoom) {

        var savedClassRoom = this.service.save(ClassRoom);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClassRoom.id())
                .toUri();

        return ResponseEntity.created(location).body(savedClassRoom);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody ClassRoomRequest ClassRoom) {

        this.service.update(id, ClassRoom);
        return ResponseEntity.ok().build();

    }
}
