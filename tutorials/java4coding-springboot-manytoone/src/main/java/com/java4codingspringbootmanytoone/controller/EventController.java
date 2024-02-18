package com.java4codingspringbootmanytoone.controller;

import com.java4codingspringbootmanytoone.model.Event;
import com.java4codingspringbootmanytoone.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.saveEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        List<Event> eventList = eventService.getAllEvents();
        return eventList;
    }
}

