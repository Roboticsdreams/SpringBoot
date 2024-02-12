package com.dailycodebufferspringdatajpa.repository;

import com.dailycodebufferspringdatajpa.entity.Guardian;
import com.dailycodebufferspringdatajpa.entity.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTest {

    @Autowired
    public StudentRepository studentRepository;

    @Test
    @Order(1)
    public void saveStudent() {
        Guardian guardian1 = Guardian.builder()
                .name("guardian")
                .email("guardian@gmail.com")
                .mobile("9876543210")
                .build();
        Student s1 = Student.builder()
                .firstName("john")
                .lastName("donne")
                .emailId("john.donne@gmail.com")
                .guardian(guardian1)
                .build();
        studentRepository.save(s1);
        Student s2 = Student.builder()
                .firstName("tommy")
                .lastName("gray")
                .emailId("tomygray@gmail.com")
                .guardian(guardian1)
                .build();
        studentRepository.save(s2);
        assertEquals(studentRepository.count(),2);
    }

    @Test
    @Order(2)
    public void getAllStudents() {
        List<Student> ss = studentRepository.findAll();
        assertEquals(ss.size(),2);
    }

    @Test
    @Order(3)
    public void getStudentByStudentId() {
        Student student = studentRepository.getStudentByEmailId("john.donne@gmail.com");
        Student expected = studentRepository.findByStudentId(student.getStudentId());
        Guardian guardian = Guardian.builder()
                .name("guardian")
                .email("guardian@gmail.com")
                .mobile("9876543210")
                .build();
        Student actual = Student.builder()
                .studentId(student.getStudentId())
                .firstName("john")
                .lastName("donne")
                .emailId("john.donne@gmail.com")
                .guardian(guardian)
                .build();
        assertEquals(expected,actual);
    }

    @Test
    @Order(4)
    public void getStudentByFirstName() {
        List<Student> list= studentRepository.findByFirstName("john");
        assertEquals(list.get(0).getFirstName(),"john");
    }

    @Test
    @Order(5)
    public void getStudentByGuardianName() {
        Student student = studentRepository.findByFirstNameAndLastName("john","donne");
        assertEquals(student.getFirstName(),"john");
    }

    @Test
    @Order(6)
    public void getStudentByFirstNameAndLastName() {
        List<Student> list = studentRepository.findByGuardianName("guardian");
        assertEquals(list.size(),2);
    }

    @Test
    @Order(7)
    public void getStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("john.donne@gmail.com");
        assertEquals(student.getEmailId(),"john.donne@gmail.com");
    }

    @Test
    @Order(8)
    public void getStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailIdNative("john.donne@gmail.com");
        assertEquals(student.getEmailId(),"john.donne@gmail.com");
    }

    @Test
    @Order(9)
    public void getStudentByEmailIdNativeWithParams() {
        Student student = studentRepository.getStudentByEmailIdNativeWithParams("john.donne@gmail.com");
        assertEquals(student.getEmailId(),"john.donne@gmail.com");
    }

    @Test
    @Order(10)
    public void updateStudentNameByEmailId() {
        int Id = studentRepository.updateStudentNameByEmailId("john" ,"john.donne@gmail.com");
        Student s = studentRepository.getStudentByEmailId("john.donne@gmail.com");
        assertEquals(s.getFirstName(),"john");
    }

    @Test
    @Order(11)
    public void deleteStudent() {
        Student student = studentRepository.getStudentByEmailId("john.donne@gmail.com");
        Student s1 = studentRepository.findByStudentId(student.getStudentId());
        assert s1 != null;
        studentRepository.delete(s1);
        List<Student> studentList = studentRepository.findAll();
        assertEquals(studentList.size() ,1);
    }

    @Test
    @Order(12)
    public void deleteAllStudent() {
        studentRepository.deleteAll();
        List<Student> studentList = studentRepository.findAll();
        assertEquals(studentList.size() ,0);
    }
}
