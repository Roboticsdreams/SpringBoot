package com.dailycodebufferspringdatajpa.repository;

import com.dailycodebufferspringdatajpa.entity.Course;
import com.dailycodebufferspringdatajpa.entity.CourseMaterial;
import com.dailycodebufferspringdatajpa.repository.CourseMaterialRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseMaterialRepositoryTest {
    @Autowired
    public CourseMaterialRepository courseMaterialRepository;

    @Test
    @Order(1)
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .name("DSA")
                .credits(9)
                .build();
        CourseMaterial courseMaterial =CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    @Order(2)
    public void saveCourseMaterialWithoutCourse() {
        assertThrows(
                DataIntegrityViolationException.class,
                () -> {
                    CourseMaterial courseMaterial = CourseMaterial.builder()
                    .url("www.google.com")
                    .build();
                    courseMaterialRepository.save(courseMaterial);
                },
                "DataIntegrityViolationException");
    }

    @Test
    @Order(3)
    public void getAllCourseMaterials(){
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        assertEquals(list.get(0).getUrl(),"www.google.com");
    }

    @Test
    @Order(4)
    public void deleteAllCourseMaterials() {
        courseMaterialRepository.deleteAll();
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        assertEquals(list.size(),0);
    }

}

