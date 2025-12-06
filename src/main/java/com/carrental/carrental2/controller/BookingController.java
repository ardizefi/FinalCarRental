package com.carrental.carrental2.controller;

import com.carrental.carrental2.dto.BookingDTO;
import com.carrental.carrental2.model.Booking;
import com.carrental.carrental2.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService bookingService;
    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN', 'CUSTOMER')")
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO dto) {
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }
    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAllBookings();
    }

    @PreAuthorize("hasAnyRole('SUPERADMIN' ,'ADMIN')")
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }
}
