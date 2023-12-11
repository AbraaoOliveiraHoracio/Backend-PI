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

import com.example.backendpi.dtos.HoursRequest;
import com.example.backendpi.dtos.HoursResponse;

import com.example.backendpi.mappers.HoursMapper;

import com.example.backendpi.services.HoursService;

@RestController
@RequestMapping("hours")
public class HoursController {

    @Autowired
    private HoursService service;

    @GetMapping
    public ResponseEntity<List<HoursResponse>> gethourss() {

        var hourss = this.service.getHours();
        return ResponseEntity.ok(HoursMapper.toDTOList(hourss));

    }

    @GetMapping("{id}")
    public ResponseEntity<HoursResponse> gethourss(@PathVariable long id) {

        var hours = this.service.getHours(id);
        return ResponseEntity.ok(HoursMapper.toDTO(hours));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletehours(@PathVariable long id) {

        this.service.deleteHoursById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<HoursResponse> save(@Validated @RequestBody HoursRequest hours) {

        var savedhours = this.service.save(hours);
        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedhours.id())
                .toUri();

        return ResponseEntity.created(location).body(savedhours);

    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Validated @RequestBody HoursRequest hours) {

        this.service.update(id, hours);
        return ResponseEntity.ok().build();

    }

}
