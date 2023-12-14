package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.backendpi.dtos.HoursRequest;
import com.example.backendpi.dtos.HoursResponse;
import com.example.backendpi.entities.Hours;

public class HoursMapper {

    public static Hours toEntity(HoursRequest request) {
        Hours hours = new Hours();
        hours.setStart(request.start());
        hours.setEnd(request.end());
        hours.setDay(request.day());
        hours.setDiscipline(request.discipline());
        hours.setCouse(request.course());
        hours.setClassroom(request.classroom());

        return hours;
    }

    public static HoursResponse toDTO(Hours Hours) {
        return new HoursResponse(
                Hours.getId(),
                Hours.getStart(),
                Hours.getEnd(),
                Hours.getDay(),
                Hours.getDiscipline(),
                Hours.getCourse(),
                Hours.getClassRoom()

        );
    }

    public static List<HoursResponse> toDTOList(List<Hours> Hours) {
        return Hours.stream().map(HoursMapper::toDTO).collect(Collectors.toList());
    }
}