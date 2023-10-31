package com.example.backendpi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendpi.dtos.TeacherRequest;
import com.example.backendpi.dtos.TeacherResponse;
import com.example.backendpi.entities.Teacher;
import com.example.backendpi.mappers.TeacherMappers;
import com.example.backendpi.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<Teacher> getTeachers() {

        return this.repository.findAll();

    }

    public Teacher getTeachers(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado!"));

    }

    public void deleteTeacherById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Professor não encontrado!");

        }
    }

    public TeacherResponse save(TeacherRequest Teacher) {

        var entity = this.repository.save(TeacherMappers.toEntity(Teacher));
        return TeacherMappers.toDTO(entity);

    }

    public void update(long id, TeacherRequest Teacher) {

        try {
            var updateTeacher = this.repository.getReferenceById(id);
            updateTeacher.setName(Teacher.name());
            updateTeacher.setCpf(Teacher.cpf());
            updateTeacher.setEmail(Teacher.email());
            updateTeacher.setTelefone(Teacher.telefone());
            updateTeacher.setDiscipline(Teacher.discipline());

            this.repository.save(updateTeacher);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Professor não encontrado!");
        }

    }

}
