package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.backendpi.dtos.SchedulesRequest;
import com.example.backendpi.dtos.SchedulesResponse;
import com.example.backendpi.entities.Schedules;

public class SchedulesMapper {

    public static Schedules toEntity(SchedulesRequest request) {
        Schedules schedules = new Schedules();
        schedules.setClassRoom(ClassRoomMapper.toEntity(request.getClassRoom()));
        schedules.setCourse(CourseMapper.toEntity(request.getCourse()));
        schedules.setDiscipline(DisciplineMapper.toEntity(request.getDiscipline()));
        schedules.setHours(HoursMapper.toEntity(request.getHours()));
        schedules.setStudent(StudentMappers.toEntity(request.getStudent()));
        schedules.setTeacher(TeacherMappers.toEntity(request.getTeacher()));
        return schedules;
    }

    public static SchedulesResponse toDTO(Schedules entity) {
        return new SchedulesResponse(   );
    }

    public static List<SchedulesResponse> toDTOList(List<Schedules> schedulesList) {
        return schedulesList.stream()
                .map(SchedulesMapper::toDTO)
                .collect(Collectors.toList());
    }
}
