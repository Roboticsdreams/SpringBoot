package com.roboticsdreams.springdatajpatutorial.repository;

import com.roboticsdreams.springdatajpatutorial.entity.Course;
import com.roboticsdreams.springdatajpatutorial.entity.CourseMaterial;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        assertEquals(list.get(0).getCourseMaterialId(),1L);
    }

    @Test
    @Order(4)
    public void deleteAllCourseMaterials() {
        courseMaterialRepository.deleteAll();
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        assertEquals(list.size(),0);
    }

}

