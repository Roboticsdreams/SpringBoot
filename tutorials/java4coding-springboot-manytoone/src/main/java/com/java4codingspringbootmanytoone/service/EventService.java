package com.java4codingspringbootmanytoone.service;

import com.java4codingspringbootmanytoone.model.Event;

import java.util.List;

public interface EventService {
    Event saveEvent(Event event);

    List<Event> getAllEvents();
}
