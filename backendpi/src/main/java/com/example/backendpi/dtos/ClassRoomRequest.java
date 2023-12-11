package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClassRoomRequest(
                @NotBlank(message = "O tamanho da sala é obrigatório!") String size,
                @NotBlank(message = "O tipo da sala é obrigatótio!") String type,
                @NotBlank(message = "O andar da sala é obrigatório!") String Floor,
                SchedulesRequest schedulesRequest) {
}
