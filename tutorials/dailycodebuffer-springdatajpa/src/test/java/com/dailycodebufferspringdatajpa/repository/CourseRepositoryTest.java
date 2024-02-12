package com.dailycodebufferspringdatajpa.repository;

import com.dailycodebufferspringdatajpa.entity.Course;
import com.dailycodebufferspringdatajpa.entity.Guardian;
import com.dailycodebufferspringdatajpa.entity.Student;
import com.dailycodebufferspringdatajpa.entity.Teacher;
import com.dailycodebufferspringdatajpa.repository.CourseRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseRepositoryTest {
    @Autowired
    public CourseRepository courseRepository;

    @Test
    @Order(1)
    public void saveCourse() {
        Course course = Course.builder()
                .name("Java")
                .credits(9)
                .build();

        courseRepository.save(course);
    }

    @Test
    @Order(2)
    public void saveCoursewithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("pavithra")
                .lastName("ravi")
                .build();
        Course course = Course.builder()
                .name("Java script")
                .credits(9)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    @Order(3)
    public void saveCoursewithTeacherAndStudents() {
        Teacher teacher = Teacher.builder()
                .firstName("pavithra")
                .lastName("ravi")
                .build();

        Guardian guardian = Guardian.builder()
                .name("guardian")
                .email("guardian@gmail.com")
                .mobile("9999991111")
                .build();

        Student s1 = Student.builder()
                .firstName("aaa")
                .lastName("bbb")
                .guardian(guardian)
                .build();

        Student s2 = Student.builder()
                .firstName("ccc")
                .lastName("ddd")
                .guardian(guardian)
                .build();

        Course course = Course.builder()
                .name("Java")
                .credits(9)
                .teacher(teacher)
                .studentList(List.of(s1,s2))
                .build();

        courseRepository.save(course);
    }

    @Test
    @Order(4)
    public void getAllCourses() {
        List<Course> list = courseRepository.findAll();
        assertNull(list.get(0).getCourseMaterial());
    }

    @Test
    @Order(5)
    public void deleteAllCourses() {
        courseRepository.deleteAll();
        List<Course> list = courseRepository.findAll();
        System.out.println(list);
        assertEquals(list.size(),0);
    }
}
