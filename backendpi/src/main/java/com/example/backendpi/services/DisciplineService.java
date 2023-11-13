package com.example.backendpi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backendpi.dtos.DisciplineRequest;
import com.example.backendpi.dtos.DisciplineResponse;
import com.example.backendpi.entities.Discipline;
import com.example.backendpi.mappers.DisciplineMapper;
import com.example.backendpi.repositories.DisciplineRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository repository;

    public List<Discipline> getDisciplines() {

        return this.repository.findAll();

    }

    public Discipline getDisciplines(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disciplina não encontrada!"));

    }

    public void deleteDisciplineById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Disciplina não encontrada!");

        }
    }

    public DisciplineResponse save(DisciplineRequest Discipline) {

        var entity = this.repository.save(DisciplineMapper.toEntity(Discipline));
        return DisciplineMapper.toDTO(entity);

    }

    public void update(long id, DisciplineRequest Discipline) {

        try {
            var updateDiscipline = this.repository.getReferenceById(id);
            updateDiscipline.setName(Discipline.name());
            updateDiscipline.setSize(Discipline.size());
            this.repository.save(updateDiscipline);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Disciplina não encontrada!");
        }

    }

}
