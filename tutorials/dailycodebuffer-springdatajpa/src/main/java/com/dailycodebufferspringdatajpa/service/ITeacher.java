package com.dailycodebufferspringdatajpa.service;


import com.dailycodebufferspringdatajpa.entity.Teacher;

import java.util.List;

public interface ITeacher {
    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    void deleteAllTeachers();
}
