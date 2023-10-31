package com.example.backendpi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendpi.dtos.StudentRequest;
import com.example.backendpi.dtos.StudentResponse;
import com.example.backendpi.entities.Student;
import com.example.backendpi.mappers.StudentMappers;
import com.example.backendpi.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getStudents() {

        return this.repository.findAll();

    }

    public Student getStudents(long id) {

        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado!"));

    }

    public void deleteStudentById(long id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Aluno não encontrado!");

        }
    }

    public StudentResponse save(StudentRequest Student) {

        var entity = this.repository.save(StudentMappers.toEntity(Student));
        return StudentMappers.toDTO(entity);

    }

    public void update(long id, StudentRequest Student) {

        try {
            var updateStudent = this.repository.getReferenceById(id);
            updateStudent.setName(Student.name());
            updateStudent.setCpf(Student.cpf());
            updateStudent.setEmail(Student.email());
            updateStudent.setTelefone(Student.telefone());

            this.repository.save(updateStudent);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Aluno não encontrado!");
        }

    }

}
