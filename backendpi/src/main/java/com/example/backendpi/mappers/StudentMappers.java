package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.backendpi.dtos.StudentRequest;
import com.example.backendpi.dtos.StudentResponse;
import com.example.backendpi.entities.Student;

public class StudentMappers {

    public static Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.name());
        student.setCpf(request.cpf());
        student.setPhone(request.phone());
        student.setEmail(request.email());
        return student;
    }

    public static StudentResponse toDTO(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getCpf(),
                student.getPhone(),
                student.getEmail(), null);
    }

    public static List<StudentResponse> toDTOList(List<Student> students) {
        return students.stream()
                .map(StudentMappers::toDTO)
                .collect(Collectors.toList());
    }
}
