package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeacherRequest(
        @NotBlank(message = "O Nome é obrigatório!") String name,
        @NotBlank(message = "O CPF é obrigatório!") String cpf,
        @NotBlank(message = "O telefone é obrigatório!") String telefone,
        @NotBlank(message = "O email é obrigatório") String email,
        @NotBlank(message = "A disciplina é obrigatória") String discipline)

{

}
