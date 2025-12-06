package com.carrental.carrental2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    @NotBlank(message = "First name is required")
    private String name;

    @NotBlank(message = "Last name name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    private  String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
}
