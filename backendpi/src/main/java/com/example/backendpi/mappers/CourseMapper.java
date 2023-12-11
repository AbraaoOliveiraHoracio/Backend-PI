package com.example.backendpi.mappers;

import com.example.backendpi.dtos.CourseRequest;
import com.example.backendpi.dtos.CourseResponse;
import com.example.backendpi.entities.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {
    public static Course toEntity(CourseRequest request) {
        Course course = new Course();
        course.setName(request.name());
        course.setSize(request.size());
        course.setPeriod(request.period());
        return course;
    }

    public static CourseResponse toDTO(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getName(),
                course.getSize(),
                course.getPeriod());
    }

    public static List<CourseResponse> toDTOList(List<Course> course) {
        return course.stream().map(CourseMapper::toDTO).collect(Collectors.toList());
    }

}
