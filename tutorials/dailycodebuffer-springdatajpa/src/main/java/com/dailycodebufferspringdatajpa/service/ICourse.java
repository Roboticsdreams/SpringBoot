package com.dailycodebufferspringdatajpa.service;

import com.dailycodebufferspringdatajpa.entity.Course;

import java.util.List;

public interface ICourse {
    Course saveCourse(Course course);
    List<Course> getAllCourses();

    void deleteAllCourses();
}
