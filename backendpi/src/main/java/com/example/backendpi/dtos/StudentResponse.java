package com.example.backendpi.dtos;

public record StudentResponse(

        Long id,
        String name,
        String email,
        String telefone,
        String cpf) {
}