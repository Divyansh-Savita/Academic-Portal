package com.example.acdemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.acdemic.respository.StudentRepository;
import com.example.acdemic.student.Student;

@Service
public class StudentServiceImpll implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpll(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // create
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // read all
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // read one
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // update
    @Override
    public Student updateStudent(Long id, Student student) {
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
    @Override
    public void deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(existingStudent);
    }

}
