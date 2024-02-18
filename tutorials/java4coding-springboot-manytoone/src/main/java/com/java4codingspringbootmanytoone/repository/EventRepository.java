package com.java4codingspringbootmanytoone.repository;

import com.java4codingspringbootmanytoone.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
