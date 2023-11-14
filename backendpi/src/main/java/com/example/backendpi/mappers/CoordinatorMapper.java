package com.example.backendpi.mappers;

import java.util.stream.Collectors;
import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> fa14e22 (Commit 1 - Coordenador)
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
<<<<<<< HEAD
                coordinator.getId(),
                coordinator.getName(),
                coordinator.getPass(),
                coordinator.getTelefone(),
                coordinator.getEmail());
=======
            coordinator.getId(),
            coordinator.getName(),
            coordinator.getPass(),
            coordinator.getTelefone(),
            coordinator.getEmail()
        );
>>>>>>> fa14e22 (Commit 1 - Coordenador)
    }

    public static List<CoordinatorResponse> toDTOList(List<Coordinator> coordinators) {
        return coordinators.stream()
<<<<<<< HEAD
                .map(CoordinatorMapper::toDTO)
                .collect(Collectors.toList());
=======
            .map(CoordinatorMapper::toDTO)
            .collect(Collectors.toList());
>>>>>>> fa14e22 (Commit 1 - Coordenador)
    }
}
