package com.java4codingspringbootmanytoone.controller;


import com.java4codingspringbootmanytoone.model.Ticket;
import com.java4codingspringbootmanytoone.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/tickets")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        Ticket bookedTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookedTicket);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        List<Ticket> ticketList = ticketService.getAllTickets();
        return ticketList;
    }
}
