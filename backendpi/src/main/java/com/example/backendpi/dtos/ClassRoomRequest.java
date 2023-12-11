package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClassRoomRequest(
        @NotBlank(message = "O tipo da sala é obrigatório!") String type,
        @NotBlank(message = "O tamanho da sala é obrigatótio!") String size,
        @NotBlank(message = "O andar da sala é obrigatório!") String floor) {
}
