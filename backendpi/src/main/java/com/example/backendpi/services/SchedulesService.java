package com.example.backendpi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendpi.dtos.SchedulesRequest;
import com.example.backendpi.dtos.SchedulesResponse;
import com.example.backendpi.entities.ClassRoom;
import com.example.backendpi.entities.Discipline;
import com.example.backendpi.entities.Hours;
import com.example.backendpi.entities.Schedules;
import com.example.backendpi.entities.Student;
import com.example.backendpi.entities.Teacher;
import com.example.backendpi.mappers.ClassRoomMapper;
import com.example.backendpi.mappers.DisciplineMapper;
import com.example.backendpi.mappers.HoursMapper;
import com.example.backendpi.mappers.SchedulesMapper;
import com.example.backendpi.mappers.StudentMappers;
import com.example.backendpi.repositories.SchedulesRepository;
import com.example.backendpi.mappers.TeacherMappers;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SchedulesService {

    @Autowired
    private SchedulesRepository repository;

    public List<Schedules> getSchedules() {

        return this.repository.findAll();

    }

    public Schedules getSchedules(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado!"));

    }

    public Schedules deleteSchedulesById(long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Aluno não encontrado!");
        }
        // Não é necessário retornar null; pode simplesmente encerrar o método
        return null;
    }

    public SchedulesResponse save(SchedulesRequest Schedules) {

        var entity = this.repository.save(SchedulesMapper.toEntity(Schedules));
        return SchedulesMapper.toDTO(entity);

    }

    public void update(long id, SchedulesRequest schedulesRequest) {
        try {
            var existingSchedules = this.repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Horário não encontrado!"));

            ClassRoom classRoom = ClassRoomMapper.toEntity(schedulesRequest.getClassRoom());
            Discipline discipline = DisciplineMapper.toEntity(schedulesRequest.getDiscipline());
            Hours hours = HoursMapper.toEntity(schedulesRequest.getHours());
            Student student = StudentMappers.toEntity(schedulesRequest.getStudent());
            Teacher teacher = TeacherMappers.toEntity(schedulesRequest.getTeacher());

            existingSchedules.setClassRoom(classRoom);
            existingSchedules.setDiscipline(discipline);
            existingSchedules.setHours(hours);
            existingSchedules.setStudent(student);
            existingSchedules.setTeacher(teacher);

            this.repository.save(existingSchedules);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Horário não encontrado!");
        }
    }

    public SchedulesResponse addSchedules(SchedulesRequest SchedulesRequest) {
        var entity = this.repository.save(SchedulesMapper.toEntity(SchedulesRequest));
        return SchedulesMapper.toDTO(entity);
    }

}
