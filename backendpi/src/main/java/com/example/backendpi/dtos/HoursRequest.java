package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record HoursRequest(

        @NotBlank(message = "Informe o horário de início da aula!") String start,
        @NotBlank(message = "Informe o horário de término da aula!") String end,
        @NotBlank(message = "Informe os dias que terão aula") String day,
        @NotBlank(message = "Informe a disciplina") String discipline,
        @NotBlank(message = "Informe o nome do curso") String course,
        @NotBlank(message= "Informe a sala de aula") String classroom) {
}
