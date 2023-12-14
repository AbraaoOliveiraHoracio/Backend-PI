package com.example.backendpi.dtos;

public record ClassRoomResponse(
        long id,
        String type,
        String size,
        String floor) {
}
