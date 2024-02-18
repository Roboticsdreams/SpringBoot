package com.java4codingspringbootmanytoone.service;

import com.java4codingspringbootmanytoone.model.Event;
import com.java4codingspringbootmanytoone.model.Ticket;
import com.java4codingspringbootmanytoone.repository.EventRepository;
import com.java4codingspringbootmanytoone.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        Long eventID = ticket.getEvent().getId();
        Event event = eventRepository.findById(eventID).orElse(null);
        assert event != null;
        double audltfair = ticket.getNoofaudults() * event.getAdult_price();
        double childfair = ticket.getNoofchilds() * event.getChild_price();
        ticket.setTotalamount(audltfair+childfair);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
