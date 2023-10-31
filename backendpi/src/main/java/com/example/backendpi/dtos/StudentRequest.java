package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record StudentRequest(

        @NotBlank(message = "O Nome é obrigatório!") String name,
        @NotBlank(message = "O cpf é obrigatóriO!") String cpf,
        @NotBlank(message = "O telefone é obrigatório!") String telefone,
        @NotBlank(message = "O email é obrigatório") String email

) {

}
