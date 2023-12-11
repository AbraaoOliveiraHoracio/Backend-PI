package com.example.backendpi.dtos;

public record StudentResponse(

        Long id,
        String name,
        String email,
        String phone,
        String cpf,
        SchedulesResponse SchedulesResponse) {
}