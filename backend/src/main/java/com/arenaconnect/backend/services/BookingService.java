package com.arenaconnect.backend.services;

import com.arenaconnect.backend.models.Booking;
import com.arenaconnect.backend.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByFacilityId(Long facilityId) {
        return bookingRepository.findByFacilityId(facilityId);
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Object saveBooking(Booking any) {
        return null;
    }

    public void deleteBooking(long l) {
    }
}
