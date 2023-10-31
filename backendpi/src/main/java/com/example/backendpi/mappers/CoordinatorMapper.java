package com.example.backendpi.mappers;

import java.util.stream.Collectors;
import java.util.List;

import com.example.backendpi.dtos.CoordinatorRequest;
import com.example.backendpi.dtos.CoordinatorResponse;
import com.example.backendpi.entities.Coordinator;

public class CoordinatorMapper {

    public static Coordinator toEntity(CoordinatorRequest request) {
        Coordinator coordinator = new Coordinator();
        coordinator.setName(request.name());
        coordinator.setPass(request.pass());
        coordinator.setTelefone(request.telefone());
        coordinator.setEmail(request.email());
        return coordinator;
    }

    public static CoordinatorResponse toDTO(Coordinator coordinator) {
        return new CoordinatorResponse(
            coordinator.getId(),
            coordinator.getName(),
            coordinator.getPass(),
            coordinator.getTelefone(),
            coordinator.getEmail()
        );
    }

    public static List<CoordinatorResponse> toDTOList(List<Coordinator> coordinators) {
        return coordinators.stream()
            .map(CoordinatorMapper::toDTO)
            .collect(Collectors.toList());
    }
}
