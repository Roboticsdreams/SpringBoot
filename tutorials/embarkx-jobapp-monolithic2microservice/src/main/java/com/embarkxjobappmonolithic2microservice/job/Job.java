package com.embarkxjobappmonolithic2microservice.job;

import com.embarkxjobappmonolithic2microservice.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tbl_job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private int minsalary;
    private int maxsalary;
    private String location;

    @JsonIgnore
    @ManyToOne
    private Company company;
}
