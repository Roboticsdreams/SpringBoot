package com.java4codingspringbootmanytoone.repository;

import com.java4codingspringbootmanytoone.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
