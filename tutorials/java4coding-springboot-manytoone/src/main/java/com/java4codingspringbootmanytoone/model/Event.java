package com.java4codingspringbootmanytoone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private double adult_price;
    private double child_price;
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ticket> ticketList;

    public Event(){
        this.ticketList = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        if(ticketList == null){
            this.ticketList = new ArrayList<>();
        }
        ticketList.add(ticket);
    }
}
