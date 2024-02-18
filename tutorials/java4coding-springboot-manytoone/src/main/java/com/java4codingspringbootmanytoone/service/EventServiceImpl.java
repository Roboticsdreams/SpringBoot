package com.java4codingspringbootmanytoone.service;

import com.java4codingspringbootmanytoone.model.Event;
import com.java4codingspringbootmanytoone.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;
    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
