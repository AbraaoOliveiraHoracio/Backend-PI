package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeacherRequest(
        @NotBlank(message = "O Nome é obrigatório!") String name,
        String cpf,
        @NotBlank(message = "O phone é obrigatório!") String phone,
        @NotBlank(message = "O email é obrigatório") String email,
        String discipline)

{

}
