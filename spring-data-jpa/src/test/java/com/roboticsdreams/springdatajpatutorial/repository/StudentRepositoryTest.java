package com.roboticsdreams.springdatajpatutorial.repository;

import com.roboticsdreams.springdatajpatutorial.entity.Guardian;
import com.roboticsdreams.springdatajpatutorial.entity.Student;
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
                .firstName("rathina")
                .lastName("vel")
                .emailId("p.rathinavel@gmail.com")
                .guardian(guardian1)
                .build();
        studentRepository.save(s1);
        Student s2 = Student.builder()
                .firstName("pavithra")
                .lastName("ravi")
                .emailId("pravithrar@gmail.com")
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
        Student expected = studentRepository.findByStudentId(1L).orElse(null);
        Guardian guardian = Guardian.builder()
                .name("guardian")
                .email("guardian@gmail.com")
                .mobile("9876543210")
                .build();
        Student actual = Student.builder()
                .studentId(1L)
                .firstName("rathina")
                .lastName("vel")
                .emailId("p.rathinavel@gmail.com")
                .guardian(guardian)
                .build();
        assertEquals(expected,actual);
    }

    @Test
    @Order(4)
    public void getStudentByFirstName() {
        List<Student> list= studentRepository.findByFirstName("rathina");
        assertEquals(list.get(0).getFirstName(),"rathina");
    }

    @Test
    @Order(5)
    public void getStudentByGuardianName() {
        Student student = studentRepository.findByFirstNameAndLastName("rathina","vel");
        assertEquals(student.getStudentId(),1L);
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
        Student student = studentRepository.getStudentByEmailId("p.rathinavel@gmail.com");
        assertEquals(student.getStudentId(),1L);
    }

    @Test
    @Order(8)
    public void getStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailIdNative("p.rathinavel@gmail.com");
        assertEquals(student.getStudentId(),1L);
    }

    @Test
    @Order(9)
    public void getStudentByEmailIdNativeWithParams() {
        Student student = studentRepository.getStudentByEmailIdNativeWithParams("p.rathinavel@gmail.com");
        assertEquals(student.getStudentId(),1L);
    }

    @Test
    @Order(10)
    public void updateStudentNameByEmailId() {
        int Id = studentRepository.updateStudentNameByEmailId("rathinam" ,"p.rathinavel@gmail.com");
        Student s = studentRepository.getStudentByEmailId("p.rathinavel@gmail.com");
        assertEquals(s.getFirstName(),"rathinam");
    }

    @Test
    @Order(11)
    public void deleteStudent() {
        Student s1 = studentRepository.findByStudentId(1L).orElse(null);
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
