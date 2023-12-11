package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record DisciplineRequest(

        @NotBlank(message = "O Nome da disciplina é obrigatório!") String name,
         String size) {

}
