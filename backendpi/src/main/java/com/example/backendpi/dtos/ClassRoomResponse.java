package com.example.backendpi.dtos;

public record ClassRoomResponse(
                long id,
                String size,
                String type,
                String Floor,
                SchedulesResponse SchedulesResponse) {
}
