package com.dailycodebufferspringdatajpa.service;

import com.dailycodebufferspringdatajpa.entity.Course;
import com.dailycodebufferspringdatajpa.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourse {
    @Autowired
    public CourseRepository courseRepository;
    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
