package com.carrental.carrental2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "car")
    private List<Booking> bookings;

    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;
    private String transmission;
    private String fuelType;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Car(Long id, String color, String brand, String model, int year,
               double price, String transmission, String fuelType, Status status) {

        this.id = id;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.status = status;
    }


}
