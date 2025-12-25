package dataStructures.arrayList.exerciseThree.booking;

import dataStructures.arrayList.exerciseOne.user.User;
import dataStructures.arrayList.exerciseThree.booking.dao.ListBookingDAO;
import dataStructures.arrayList.exerciseTwo.car.Brand;
import dataStructures.arrayList.exerciseTwo.car.Car;
import dataStructures.arrayList.exerciseTwo.car.FuelType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookingExample {

    public static void main(String[] args) {

        ListBookingDAO listBookingDAO = new ListBookingDAO();

        ///  Question 1
        System.out.println("Question 1: get all bookings");
        List<Booking> allUser = listBookingDAO.getBookings();
        allUser.forEach(System.out::println);
        System.out.println();

        ///  Question 2
        System.out.println("Question 2: get the number of bookings");
        System.out.println("The number of active bookings registered in the system is: " +  listBookingDAO.getNumberOfBookings());
        listBookingDAO.displayAllBookings();
        System.out.println();

        ///  Question 3
        System.out.println("Question 4: add a booking");

        Booking newBookingOne =  new Booking(UUID.randomUUID(),

                new User(UUID.randomUUID(), "Barry", "LeWhite"),

                new Car("123_1", new BigDecimal("89.00"), Brand.BMW, FuelType.ELECTRIC),

                LocalDateTime.now());

        Booking newBookingTwo =  new Booking(UUID.randomUUID(),

                new User(UUID.randomUUID(), "Whitney", "Brewster"),

                new Car("123_2", new BigDecimal("79.00"), Brand.BMW, FuelType.GASOLINE),

                LocalDateTime.now());

        listBookingDAO.addBooking(newBookingOne);
        listBookingDAO.addBooking(newBookingTwo);
        listBookingDAO.displayAllBookings();
        System.out.println();

        ///  Question 3
        System.out.println("Question 3: booking booking");
        listBookingDAO.removeBooking(newBookingOne);

        System.out.println("The number of active bookings registered in the system is: " +  listBookingDAO.getNumberOfBookings());
        listBookingDAO.displayAllBookings();
        System.out.println();

        ///  Question 4
        System.out.println("Question 4: get booking by id");
        Booking newBookingTwoByID = listBookingDAO.getBookingById(newBookingTwo.getUserBookingID());
        System.out.println(newBookingTwoByID);
        System.out.println();

    }
}
