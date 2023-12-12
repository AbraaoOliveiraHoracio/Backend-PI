package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeacherRequest(
        @NotBlank(message = "O Nome é obrigatório!") String name,
        @NotBlank(message = "O email é obrigatório") String email,
        @NotBlank(message = "O phone é obrigatório!") String pass)

{

}
