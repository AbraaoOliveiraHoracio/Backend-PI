package com.example.backendpi.dtos;

public record HoursRequest(
        String start,
        String end,
        String day,
        String Hours) {

}
