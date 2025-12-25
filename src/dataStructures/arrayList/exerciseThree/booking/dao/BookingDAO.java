package dataStructures.arrayList.exerciseThree.booking.dao;

import dataStructures.arrayList.exerciseThree.booking.Booking;

import java.util.List;
import java.util.UUID;

/**
 *      BookingDAO defines the contract for all data
 *      access operations related to Booking entities
 * */

public interface BookingDAO {

    void addBooking(Booking booking);

    void removeBooking(Booking booking);

    List<Booking> getBookings();

    Booking getBookingById(UUID bookingId);

    int getNumberOfBookings();

    void displayAllBookings();

}
