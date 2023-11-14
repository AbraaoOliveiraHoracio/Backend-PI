package com.example.backendpi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backendpi.dtos.HoursRequest;
import com.example.backendpi.dtos.HoursResponse;
import com.example.backendpi.entities.Hours;
import com.example.backendpi.mappers.HoursMapper;
import com.example.backendpi.repositories.HoursRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class HoursService {

    @Autowired
    private HoursRepository repository;

    public List<Hours> getHours() {

        return this.repository.findAll();

    }

    public Hours getHours(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada!"));

    }

    public void deleteHoursById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Disciplina não encontrada!");

        }
    }

    public HoursResponse save(HoursRequest Hours) {

        var entity = this.repository.save(HoursMapper.toEntity(Hours));
        return HoursMapper.toDTO(entity);

    }

    public void update(long id, HoursRequest Hours) {

        try {
            var updateHours = this.repository.getReferenceById(id);
            updateHours.setStart(Hours.start());
            updateHours.setEnd(Hours.end());
            updateHours.setDay(Hours.day());
            updateHours.setHours(Hours.Hours());
            this.repository.save(updateHours);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Disciplina não encontrada!");
        }

    }

}
