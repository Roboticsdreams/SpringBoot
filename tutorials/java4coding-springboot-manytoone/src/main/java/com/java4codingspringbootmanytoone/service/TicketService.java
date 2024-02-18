package com.java4codingspringbootmanytoone.service;

import com.java4codingspringbootmanytoone.model.Ticket;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket ticket);

    List<Ticket> getAllTickets();
}
