package com.example.service;

import com.example.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void updateStudent(Student student);
    void deleteStudentById(Long id);
    void deleteStudentByEntity(Student student);




}
