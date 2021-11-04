package dev.cironeto.springbootdevdojo.service;

import dev.cironeto.springbootdevdojo.domain.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StudentService {

    public static List<Student> students =
            new ArrayList<>(List.of(new Student(1, "Ciro Neto"), new Student(2, "Amanda")));


    public List<Student> listAll() {
        return students;
    }

    public Student findById(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not found"));
    }

    public Student save(Student student) {
        student.setId(ThreadLocalRandom.current().nextLong(3, 100));
        students.add(student);
        return student;
    }

    public void delete(long id) {
        students.remove(findById(id));
    }

    public void replace(Student student) {
        delete(student.getId());
        students.add(student);
    }
}
