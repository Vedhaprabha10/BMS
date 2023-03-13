package com.example.Bms.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Size(max = 10,message = "Enter a valid name")
    private String name;
    @Email
    //@Pattern(regexp = "")
    private String email;
    @NotEmpty
    @Size(max = 100)
    private String address;
    @Max(9999999999l)
    @Min(1000000000)
    @NotNull
    private Long phone;

}
