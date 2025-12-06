package com.carrental.carrental2.dto;

import com.carrental.carrental2.model.BookingStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long id;

    private Long customerId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;

    private BookingStatus status;

}
