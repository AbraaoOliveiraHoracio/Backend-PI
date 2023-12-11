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

import com.example.backendpi.dtos.SchedulesRequest;
import com.example.backendpi.dtos.SchedulesResponse;
import com.example.backendpi.entities.Schedules;
import com.example.backendpi.mappers.SchedulesMapper;
import com.example.backendpi.services.SchedulesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Schedules")
public class SchedulesController {
    private final SchedulesService service;

    public SchedulesController(SchedulesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SchedulesResponse>> getSchedules() {
        List<Schedules> schedules = service.getSchedules();
        return ResponseEntity.ok(SchedulesMapper.toDTOList(schedules));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulesResponse> getSchedulesById(@PathVariable long id) {
        Schedules schedules = service.getSchedules(id);
        return ResponseEntity.ok(SchedulesMapper.toDTO(schedules));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedules(@PathVariable long id) {
        service.deleteSchedulesById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<SchedulesResponse> saveSchedules(@Valid @RequestBody SchedulesRequest schedulesRequest) {
        SchedulesResponse savedSchedules = service.save(schedulesRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSchedules.getId())
                .toUri();
        return ResponseEntity.created(location).body(SchedulesMapper.toDTO(savedSchedules));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchedules(@PathVariable long id,
            @Valid @RequestBody SchedulesRequest schedulesRequest) {
        service.update(id, schedulesRequest);
        return ResponseEntity.ok().build();
    }
}
