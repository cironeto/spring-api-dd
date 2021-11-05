package dev.cironeto.springbootdevdojo.repository;

import dev.cironeto.springbootdevdojo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
