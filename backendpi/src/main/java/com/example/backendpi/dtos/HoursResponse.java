package com.example.backendpi.dtos;

public record HoursResponse(
        long id,
        String start,
        String end,
        String day,
        String Hours,
        SchedulesResponse SchedulesResponse) {
}
