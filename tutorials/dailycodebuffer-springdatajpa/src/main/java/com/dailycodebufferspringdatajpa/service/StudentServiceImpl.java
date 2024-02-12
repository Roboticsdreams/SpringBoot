package com.dailycodebufferspringdatajpa.service;

import com.dailycodebufferspringdatajpa.entity.Student;
import com.dailycodebufferspringdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudent{

    @Autowired
    public StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findByStudentId(id);
    }

    @Override
    public List<Student> getStudentByFirstName(String name) {
        return studentRepository.findByFirstName(name);
    }

    @Override
    public Student getStudentByFirstNameAndLastName(String firstname, String lastname) {
        return studentRepository.findByFirstNameAndLastName(firstname,lastname);
    }

    @Override
    public List<Student> getStudentByGuardianName(String name) {
        return studentRepository.findByGuardianName(name);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }
}
