package com.example.backendpi.dtos;

public record TeacherResponse(

        Long id,
        String name,
        String telefone,
        String cpf,
        String discipline,
        String email

) {
}