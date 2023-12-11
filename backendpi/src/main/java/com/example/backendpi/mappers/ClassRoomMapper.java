package com.example.backendpi.mappers;

import java.util.List;
import java.util.stream.Collectors;
import com.example.backendpi.dtos.ClassRoomRequest;
import com.example.backendpi.dtos.ClassRoomResponse;
import com.example.backendpi.entities.ClassRoom;

public class ClassRoomMapper {
    public static ClassRoom toEntity(ClassRoomRequest request) {
        ClassRoom ClassRoom = new ClassRoom();
        ClassRoom.setFloor(request.Floor());
        ClassRoom.setSize(request.size());
        ClassRoom.setType(request.type());
        return ClassRoom;
    }

    public static ClassRoomResponse toDTO(ClassRoom ClassRoom) {
        return new ClassRoomResponse(
                ClassRoom.getId(),
                ClassRoom.getType(),
                ClassRoom.getFloor(),
                ClassRoom.getSize(), null);
    }

    public static List<ClassRoomResponse> toDTOList(List<ClassRoom> ClassRoom) {
        return ClassRoom.stream().map(ClassRoomMapper::toDTO).collect(Collectors.toList());
    }

}
