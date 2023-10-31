// Serviços

package com.example.backendpi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendpi.dtos.CoordinatorRequest;
import com.example.backendpi.dtos.CoordinatorResponse;
import com.example.backendpi.entities.Coordinator;
import com.example.backendpi.mappers.CoordinatorMapper;
import com.example.backendpi.repositories.CoordinatorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CoordinatorService {

    @Autowired
    private CoordinatorRepository repository;

    public List<Coordinator> getCoordinators() {

        return this.repository.findAll();

    }

    public Coordinator getCoordinators(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coordenador não encontrado!"));

    }

    public void deleteCoordinatorById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Coordenador não encontrado!");

        }
    }

    public CoordinatorResponse save(CoordinatorRequest Coordinator) {

        var entity = this.repository.save(CoordinatorMapper.toEntity(Coordinator));
        return CoordinatorMapper.toDTO(entity);

    }

    public void update(long id, CoordinatorRequest Coordinator) {

        try {
            var updateCoordinator = this.repository.getReferenceById(id);
            updateCoordinator.setName(Coordinator.name());
            updateCoordinator.setPass(Coordinator.pass());
            updateCoordinator.setTelefone(Coordinator.telefone());
            updateCoordinator.setEmail(Coordinator.email());

            this.repository.save(updateCoordinator);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Coordenador não encontrado!");
        }

    }

}
