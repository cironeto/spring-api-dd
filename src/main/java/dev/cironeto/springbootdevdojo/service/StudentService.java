package dev.cironeto.springbootdevdojo.service;

import dev.cironeto.springbootdevdojo.domain.Student;
import dev.cironeto.springbootdevdojo.repository.StudentRepository;
import dev.cironeto.springbootdevdojo.requests.StudentPostRequestBody;
import dev.cironeto.springbootdevdojo.requests.StudentPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student findByIdOrThrowBadRequestException(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not found"));

    }

    public Student save(StudentPostRequestBody studentPostRequestBody) {
        return studentRepository.save(Student.builder().name(studentPostRequestBody.getName()).build());
    }

    public void delete(long id) {
        studentRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(StudentPutRequestBody studentPutRequestBody) {
        Student savedStudent = findByIdOrThrowBadRequestException(studentPutRequestBody.getId());
        studentRepository.save(Student.builder()
                .id(savedStudent.getId())
                .name(studentPutRequestBody.getName())
                .build());
    }
}
