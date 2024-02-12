package com.dailycodebufferspringdatajpa.repository;


import com.dailycodebufferspringdatajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Reference: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
*/
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(Long id);
    List<Student> findByFirstName(String name);
    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByGuardianName(String name);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    //Native
    @Query(value ="select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailIdNative(String emailId);

    //Native with Params
    @Query(value ="select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailIdNativeWithParams(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}

