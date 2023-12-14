package com.example.backendpi.mappers;

import com.example.backendpi.dtos.DisciplineRequest;
import com.example.backendpi.dtos.DisciplineResponse;
import com.example.backendpi.entities.Discipline;

import java.util.List;
import java.util.stream.Collectors;

public class DisciplineMapper {

    public static Discipline toEntity(DisciplineRequest request) {
        Discipline discipline = new Discipline();
        discipline.setName(request.name());
        return discipline;
    }

    public static DisciplineResponse toDTO(Discipline discipline) {
        return new DisciplineResponse(
                discipline.getId(),
                discipline.getName());
    }

    public static List<DisciplineResponse> toDTOList(List<Discipline> disciplines) {
        return disciplines.stream().map(DisciplineMapper::toDTO).collect(Collectors.toList());
    }
}
