package com.roboticsdreams.springdatajpatutorial.service;

import com.roboticsdreams.springdatajpatutorial.entity.Teacher;
import com.roboticsdreams.springdatajpatutorial.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacher {

    @Autowired
    public TeacherRepository teacherRepository;
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteAllTeachers() {
        teacherRepository.deleteAll();
    }
}
