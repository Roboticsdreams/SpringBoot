package com.java4codingspringbootmanytoone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int noofaudults;
    private int noofchilds;
    private double totalamount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id",  nullable = false)
    @JsonBackReference
    private Event event;
}
