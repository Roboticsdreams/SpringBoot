package com.roboticsdreams.springdatajpatutorial.service;

import com.roboticsdreams.springdatajpatutorial.entity.Course;

import java.util.List;

public interface ICourse {
    Course saveCourse(Course course);
    List<Course> getAllCourses();

    void deleteAllCourses();
}
