package com.carrental.carrental2.services;

import com.carrental.carrental2.dto.BookingDTO;
import com.carrental.carrental2.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(BookingDTO dto);
    List<Booking> getAllBookings();
    Booking getBooking(Long id);
}
