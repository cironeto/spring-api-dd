package dev.cironeto.springbootdevdojo.repository;

import dev.cironeto.springbootdevdojo.domain.Student;

import java.util.List;

public interface StudentRepository {
    default List<Student> listAll(){
        return List.of(new Student(1, "Ciro Neto"), new Student(2, "Amanda"));
    }



}
