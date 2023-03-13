package com.example.Bms.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class Flat {
    @Id
    @Column(name = "flatno")
    private int flatNo;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

}
