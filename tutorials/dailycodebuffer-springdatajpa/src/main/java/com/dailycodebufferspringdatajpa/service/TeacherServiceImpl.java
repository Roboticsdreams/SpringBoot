package com.dailycodebufferspringdatajpa.service;

import com.dailycodebufferspringdatajpa.entity.Teacher;
import com.dailycodebufferspringdatajpa.repository.TeacherRepository;
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
