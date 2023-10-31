// Controlador

package com.example.backendpi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.backendpi.dtos.CoordinatorRequest;
import com.example.backendpi.dtos.CoordinatorResponse;
import com.example.backendpi.mappers.CoordinatorMapper;
import com.example.backendpi.services.CoordinatorService;

@RestController
@RequestMapping("coordinator")
public class CoordinatorController {

    @Autowired
    private CoordinatorService service;

    @GetMapping
    public ResponseEntity<List<CoordinatorResponse>> getCoordinators() {

        var Coordinators = this.service.getCoordinators();
        return ResponseEntity.ok(CoordinatorMapper.toDTOList(Coordinators));

    }

    @GetMapping("{id}")
    public ResponseEntity<CoordinatorResponse> getCoordinators(@PathVariable long id) {

        var Coordinator = this.service.getCoordinators(id);
        return ResponseEntity.ok(CoordinatorMapper.toDTO(Coordinator));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCoordinator(@PathVariable long id) {

        this.service.deleteCoordinatorById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<CoordinatorResponse> save(@Validated @RequestBody CoordinatorRequest coordinator) {

        var savedCoordinator = this.service.save(coordinator);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCoordinator.id())
                .toUri();

        return ResponseEntity.created(location).body(savedCoordinator);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody CoordinatorRequest coordinator) {

        this.service.update(id, coordinator);
        return ResponseEntity.ok().build();

    }
}
