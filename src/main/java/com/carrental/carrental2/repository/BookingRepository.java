package com.carrental.carrental2.repository;

import com.carrental.carrental2.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
