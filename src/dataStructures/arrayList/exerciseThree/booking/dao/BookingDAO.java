package dataStructures.arrayList.exerciseThree.booking.dao;


import dataStructures.arrayList.exerciseThree.booking.Booking;

import java.util.UUID;

/**
 *      BookingDAO defines the contract for all data
 *      access operations related to Booking entities
 * */

public interface BookingDAO {

    ///  TODO: CONVERT CLASS TO USE ARRAY LISTS

    Booking[] getBookings();

    void addBooking(Booking carBooking);

    void removeBooking(Booking carBookingToUpdate);

    Booking getBookingById(UUID bookingId);

}
