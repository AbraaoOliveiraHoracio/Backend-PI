package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CourseRequest(
        @NotBlank(message = "O Nome do curso é obrigatório!") String name,
        @NotBlank(message = "Informe a quantia mínima de alunos do curso!") String size,
        @NotBlank(message = "Informe o período do curso") String period) {
}
