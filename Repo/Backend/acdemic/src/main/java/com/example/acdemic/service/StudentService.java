package com.example.acdemic.service;

import java.util.List;

import com.example.acdemic.respository.StudentRepository;
import com.example.acdemic.student.Student;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // create
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // read all
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // read one
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // update
    public Student updateStudent(long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYear(student.getYear());
        return studentRepository.save(existingStudent);
    }

    // delete
    public void deleteStudent(long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(existingStudent);
    }
}
