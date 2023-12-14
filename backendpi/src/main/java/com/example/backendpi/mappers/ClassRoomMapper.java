package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;
import com.example.backendpi.dtos.ClassRoomRequest;
import com.example.backendpi.dtos.ClassRoomResponse;
import com.example.backendpi.entities.ClassRoom;

public class ClassRoomMapper {
    public static ClassRoom toEntity(ClassRoomRequest request) {
        ClassRoom ClassRoom = new ClassRoom();
        ClassRoom.setType(request.type());
        ClassRoom.setSize(request.size());
        ClassRoom.setFloor(request.floor());
        return ClassRoom;
    }

    public static ClassRoomResponse toDTO(ClassRoom ClassRoom) {
        return new ClassRoomResponse(
                ClassRoom.getId(),
                ClassRoom.getType(),
                ClassRoom.getSize(),
                ClassRoom.getFloor());
    }

    public static List<ClassRoomResponse> toDTOList(List<ClassRoom> ClassRoom) {
        return ClassRoom.stream().map(ClassRoomMapper::toDTO).collect(Collectors.toList());
    }

}
