package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.backendpi.dtos.TeacherRequest;
import com.example.backendpi.dtos.TeacherResponse;
import com.example.backendpi.entities.Teacher;

public class TeacherMappers {

    public static Teacher toEntity(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.name());
        teacher.setEmail(request.email());
        teacher.setPass(request.pass());
        

        return teacher;
    }

    public static TeacherResponse toDTO(Teacher teacher) {
        return new TeacherResponse(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getPass()
                );
    }

    public static List<TeacherResponse> toDTOList(List<Teacher> teachers) {
        return teachers.stream()
                .map(TeacherMappers::toDTO)
                .collect(Collectors.toList());
    }
}
