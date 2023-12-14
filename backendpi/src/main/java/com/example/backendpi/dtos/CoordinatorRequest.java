package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CoordinatorRequest(
        @NotBlank(message = "O Nome é obrigatório!") String name,
        @NotBlank(message = "A senha é obrigatória!") String pass,
        @NotBlank(message = "O phone é obrigatório!") String phone,
        @NotBlank(message = "O email é obrigatório") String email) {

}
