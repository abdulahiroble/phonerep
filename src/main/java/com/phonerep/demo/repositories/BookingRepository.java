package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Booking;
import com.phonerep.demo.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
