package com.roboticsdreams.springdatajpatutorial.service;

import com.roboticsdreams.springdatajpatutorial.entity.Teacher;

import java.util.List;

public interface ITeacher {
    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    void deleteAllTeachers();
}
