package com.example.backendpi.dtos;

public record CourseResponse(
                long id,
                String name,
                String size,
                String period,
                SchedulesResponse SchedulesResponse) {
}
