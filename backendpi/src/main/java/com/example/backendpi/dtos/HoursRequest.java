package com.example.backendpi.dtos;

import jakarta.validation.constraints.NotBlank;

public record HoursRequest(

                long id,
                @NotBlank(message = "Informe o horário de início da aula!") String start,
                @NotBlank(message = "Informe o horário de término da aula!") String end,
                @NotBlank(message = "Informe os dias que terão aula") String day,
                @NotBlank(message = "Informe o horário das aulas") String Hours,
                SchedulesRequest schedulesRequest) {

}
