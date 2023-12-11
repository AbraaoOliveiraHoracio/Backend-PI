package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.backendpi.dtos.DisciplineRequest;
import com.example.backendpi.dtos.DisciplineResponse;
import com.example.backendpi.entities.Discipline;

public class DisciplineMapper {
    public static Discipline toEntity(DisciplineRequest request) {
        Discipline Discipline = new Discipline();
        Discipline.setSize(request.size());
        Discipline.setName(request.name());
        return Discipline;
    }

    public static DisciplineResponse toDTO(Discipline discipline) {
        return new DisciplineResponse(
                discipline.getId(),
                discipline.getSize(),
                discipline.getName(), null);
    }

    public static List<DisciplineResponse> toDTOList(List<Discipline> discipline) {
        return discipline.stream().map(DisciplineMapper::toDTO).collect(Collectors.toList());
    }
}
