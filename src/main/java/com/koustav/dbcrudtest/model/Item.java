package com.koustav.dbcrudtest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // Marks this class as a JPA entity
@Table(name = "students") // Specifies the database table name
@Getter
@Setter
public class Item {
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false) // Cannot be null
    private String name;

    @Column(nullable = false, unique = true) // Roll number must be unique
    private Integer rollNo;

    @Column(nullable = true) // Marks can be null
    private Integer marks;


}