package business;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backendpi.entities.Student;
import com.example.backendpi.repositories.StudentRepository;
import com.example.backendpi.services.StudentService;
import com.example.backendpi.dtos.StudentRequest;
import com.example.backendpi.dtos.StudentResponse;

import jakarta.persistence.EntityNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    StudentService service;

    @Mock
    StudentRepository repository;

    Student student;

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setCpf("123456789");
        student.setEmail("john.doe@example.com");
        student.setPhone("123456789");
    }

    @Test
    void getStudentById_Success() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(student));

        Student returnedStudent = service.getStudents(student.getId());

        assertThat(returnedStudent, equalTo(student));
        verify(repository).findById(eq(student.getId()));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getStudentById_NonExistentId() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        EntityNotFoundException e = assertThrows(EntityNotFoundException.class, () -> {
            service.getStudents(student.getId());
        });

        assertThat(e.getMessage(), is("Aluno não encontrado!"));
        verify(repository).findById(eq(student.getId()));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void saveStudent_Success() {
        when(repository.save(any())).thenReturn(new Student());

        StudentRequest newStudentRequest = new StudentRequest("Jane Doe", "987654321", "jane.doe@example.com",
                "987654321", null);

        StudentResponse savedStudent = service.save(newStudentRequest);

        assertThat(savedStudent, notNullValue());

        verify(repository).save(any());
        verifyNoMoreInteractions(repository);
    }
}
