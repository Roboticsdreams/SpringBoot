package com.roboticsdreams.springdatajpatutorial.repository;

import com.roboticsdreams.springdatajpatutorial.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Page<Teacher> findByFirstNameContaining(
            String firstName,
            Pageable pageable
    );
}
