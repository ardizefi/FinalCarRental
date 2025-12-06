package com.carrental.carrental2.dto;

import com.carrental.carrental2.model.Status;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private Long id;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Color is required")
    private String color;

    @Min(value = 1980, message = "Year must be at least 1980")
    @Max(value = 2030, message = "Year cannot be greater than 2030")
    private int year;

    @Positive(message = "Price must be greater than zero")
    private double price;

    private String transmission;
    private String fuelType;


    @NotNull(message = "Status is required")
    private Status status;

}
