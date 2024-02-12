package com.dailycodebufferspringdatajpa.repository;

import com.dailycodebufferspringdatajpa.entity.Teacher;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @Order(1)
    public void saveTeacher() {
        Teacher teacher1 = Teacher.builder()
                .firstName("aaaa1")
                .lastName("bbbb1")
                .build();

        Teacher teacher2 = Teacher.builder()
                .firstName("aaaa2")
                .lastName("bbbb2")
                .build();

        Teacher teacher3 = Teacher.builder()
                .firstName("aaaa3")
                .lastName("bbbb3")
                .build();

        Teacher teacher4 = Teacher.builder()
                .firstName("aaaa4")
                .lastName("bbbb4")
                .build();

        Teacher teacher5 = Teacher.builder()
                .firstName("aaaa5")
                .lastName("bbbb5")
                .build();

        teacherRepository.saveAll(List.of(teacher1,teacher2,teacher3,teacher4, teacher5));
    }

    @Test
    @Order(2)
    public void findAllPagination(){
        Pageable pageWithThreeRecords = PageRequest.of(0,3);
        List<Teacher>  teacherList = teacherRepository.findAll(pageWithThreeRecords)
                .getContent();
        assertEquals(teacherList.size(),3);
        long totalElements = teacherRepository.findAll(pageWithThreeRecords)
                .getTotalElements();
        assertEquals(totalElements,5);
        long totalPages = teacherRepository.findAll(pageWithThreeRecords).getTotalPages();
        assertEquals(totalPages,2);
    }

    @Test
    @Order(3)
    public void findAllSorting() {
        Pageable sortByLastName = PageRequest.of(0,2, Sort.by("lastName").descending().and(Sort.by("firstName")));
        List<Teacher>  teacherList = teacherRepository.findAll(sortByLastName)
                .getContent();
        assertEquals(teacherList.get(0).getLastName(),"bbbb5");
    }

    @Test
    @Order(4)
    public void findByFirstNameContaining() {
        Pageable firstPageTwoRecords = PageRequest.of(0,2);

        List<Teacher> teacherList = teacherRepository.findByFirstNameContaining("1",firstPageTwoRecords).getContent();
        assertEquals(teacherList.get(0).getFirstName(),"aaaa1");
    }

    @Test
    @Order(5)
    public void deleteAllTeachers(){
        teacherRepository.deleteAll();
        List<Teacher> teacherList = teacherRepository.findAll();
        assertEquals(teacherList.size(),0);
    }
}
