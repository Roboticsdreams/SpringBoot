package com.roboticsdreams.springdatajpatutorial.service;

import com.roboticsdreams.springdatajpatutorial.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudent {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    List<Student> getStudentByFirstName(String name);
    Student getStudentByFirstNameAndLastName(String firstname, String lastname);
    List<Student> getStudentByGuardianName(String name);
    void deleteStudent(Student student);
    void deleteAllStudent();
}
