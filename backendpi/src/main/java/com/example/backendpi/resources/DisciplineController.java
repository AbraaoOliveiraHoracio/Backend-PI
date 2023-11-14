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

import com.example.backendpi.dtos.DisciplineRequest;
import com.example.backendpi.dtos.DisciplineResponse;
import com.example.backendpi.mappers.DisciplineMapper;
import com.example.backendpi.services.DisciplineService;

@RestController
@RequestMapping("discipline")
public class DisciplineController {

    @Autowired
    private DisciplineService service;

    @GetMapping
    public ResponseEntity<List<DisciplineResponse>> getDisciplines() {

        var Disciplines = this.service.getDisciplines();
        return ResponseEntity.ok(DisciplineMapper.toDTOList(Disciplines));

    }

    @GetMapping("{id}")
    public ResponseEntity<DisciplineResponse> getDisciplines(@PathVariable long id) {

        var Discipline = this.service.getDisciplines(id);
        return ResponseEntity.ok(DisciplineMapper.toDTO(Discipline));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDiscipline(@PathVariable long id) {

        this.service.deleteDisciplineById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<DisciplineResponse> save(@Validated @RequestBody DisciplineRequest discipline) {

        var savedDiscipline = this.service.save(discipline);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDiscipline.id())
                .toUri();

        return ResponseEntity.created(location).body(savedDiscipline);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody DisciplineRequest discipline) {

        this.service.update(id, discipline);
        return ResponseEntity.ok().build();

    }
}
