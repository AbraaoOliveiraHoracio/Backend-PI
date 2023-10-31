package com.example.backendpi.dtos;

public record CoordinatorResponse(
    long id,
    String name,
    String pass,
    String telefone,
    String email
) {
    
}
