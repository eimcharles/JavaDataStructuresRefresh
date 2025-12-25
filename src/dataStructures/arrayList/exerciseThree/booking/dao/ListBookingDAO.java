package dataStructures.arrayList.exerciseThree.booking.dao;

import dataStructures.arrayList.exerciseOne.user.User;
import dataStructures.arrayList.exerciseThree.booking.Booking;
import dataStructures.arrayList.exerciseThree.exception.BookingNotFoundException;
import dataStructures.arrayList.exerciseTwo.car.Brand;
import dataStructures.arrayList.exerciseTwo.car.Car;
import dataStructures.arrayList.exerciseTwo.car.FuelType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *      ListBookingDAO is a Data Access Object (DAO)
 *      class for managing Car Booking objects,
 *      it implements BookingDAO contract.
 *
 *      This implementation stores and manages Car Bookings using ArraysLists.
 */

public class ListBookingDAO implements BookingDAO {

    private final List<Booking> bookingsDao;

    public ListBookingDAO() {

        this.bookingsDao = new ArrayList<>();

        Booking initialBooking =  new Booking(UUID.fromString("8e397f1e-e7a4-4c39-8331-968a9ab3faef"),
                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"), "Jerry", "LeBlond"),
                new Car("123_4", new BigDecimal("49.00"), Brand.HONDA, FuelType.ELECTRIC),
                LocalDateTime.now());

        addBooking(initialBooking);

    }

    @Override
    public void addBooking(Booking booking) {

        // if not null, add
        if (booking != null){
            bookingsDao.add(booking);
        }
    }

    @Override
    public void removeBooking(Booking booking) {

        // Booking to be removed
        UUID targetId = booking.getUserBookingID();

        // Looks at every booking 'b' and checks their booking ID specifically
        boolean removed = bookingsDao.removeIf(b -> b.getUserBookingID().equals(targetId));

        // Booking removed
        if (removed)
            return;

        // Booking not found
        throw new BookingNotFoundException(targetId);

    }

    @Override
    public List<Booking> getBookings() {

        // Return an empty arrayList
        if (this.bookingsDao == null || this.bookingsDao.isEmpty()){
            return new ArrayList<>();
        }

        // Copy of bookingsDao
        return new ArrayList<>(this.bookingsDao);
    }

    @Override
    public Booking getBookingById(UUID bookingId) {

        // User check
        if (bookingId == null){
            throw new IllegalArgumentException(String.format("bookingId cannot be null"));
        }

        // Iterate to find a user with matching ID
        for (int i = 0; i < this.bookingsDao.size(); i++) {
            if (bookingId.equals(bookingsDao.get(i).getUserBookingID())){
                return bookingsDao.get(i);
            }
        }

        // Booking not found
        throw new BookingNotFoundException(bookingId);

    }

    @Override
    public int getNumberOfBookings() {

        // Return the number of bookings
        return bookingsDao.size();
    }

    @Override
    public void displayAllBookings() {

        // No bookings to display
        if (bookingsDao.isEmpty())
            return;

        // Java Streams
        bookingsDao.forEach(System.out::println);
    }

}
