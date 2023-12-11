package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record DisciplineRequest(

        @NotBlank(message = "O Nome da disciplina é obrigatório!") String name,
        @NotBlank(message = "Informe a quantia de alunos da disciplina") String size,
        SchedulesRequest schedulesRequest) {

}
