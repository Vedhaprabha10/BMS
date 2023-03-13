package com.example.Bms.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Floor {
    @Id
    @Column(name = "floorno")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int floorNo;

//    @JoinColumn(name = "flat")
    @ManyToOne(cascade = CascadeType.ALL)
    private Flat flat;
}
