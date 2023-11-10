package com.example.backendpi.mappers;

import org.apache.catalina.connector.Request;

import com.example.backendpi.dtos.ClassRoomRequest;
import com.example.backendpi.entities.ClassRoom;

public class ClassRoomMapper {
    public static ClassRoom toEntity(ClassRoomRequest request){
        ClassRoom classroom = new ClassRoom();
        classroom.setFloor(request.Floor());
        classroom.setSize(request.size());
        classroom.setType(request.type());
        return classroom;
    }
}
