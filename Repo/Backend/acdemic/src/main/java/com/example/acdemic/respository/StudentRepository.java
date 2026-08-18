package com.example.acdemic.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.acdemic.student.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    void save();

    List findAll();

    void findById();

    void deleteById();

    void existsById();

}
