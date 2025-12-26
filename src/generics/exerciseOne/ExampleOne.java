package generics.exerciseOne;

import dataStructures.arrayList.exerciseOne.user.User;
import dataStructures.arrayList.exerciseThree.booking.Booking;
import dataStructures.arrayList.exerciseTwo.car.Brand;
import dataStructures.arrayList.exerciseTwo.car.Car;
import dataStructures.arrayList.exerciseTwo.car.FuelType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExampleOne {

    public static void main(String[] args) {

        /// Arbitrary Objects
        String stringObject = "String object";
        Integer integerObject = 5;
        Double doubleObject = 10.0;

        ///  Example 1:
        System.out.println("Example 1: null generic object");
        GenericClass<Object> genericObjectOne = new GenericClass<>();
        System.out.println(genericObjectOne);
        System.out.println();

        ///  Example 2:
        System.out.println("Example 2: setting generic object to type String");
        genericObjectOne.setAnyObjectType(stringObject);
        System.out.println(genericObjectOne);
        System.out.println();

        ///  Example 3:
        System.out.println("Example 3: initializing two distinct generic objects that contain Integer and String objects");
        GenericClass<Integer> genericObjectTwo = new GenericClass<>(integerObject);
        System.out.println(genericObjectTwo);

        GenericClass<Double> genericObjectThree = new GenericClass<>(doubleObject);
        System.out.println(genericObjectThree);
        System.out.println();

        ///  Example 4:
        System.out.println("Example 4: initializing a generic object that contains a user object");

        User charles = new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer");

        GenericClass<User> userGenericClass = new GenericClass<>(charles);
        System.out.println(userGenericClass);
        System.out.println();

        ///  Example 5:
        System.out.println("Example 5: initializing a generic object that contains a car object");

        Car mercedes = new Car("123_5",
                new BigDecimal("109.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        GenericClass<Car> carGenericClass = new GenericClass<>(mercedes);
        System.out.println(carGenericClass);
        System.out.println();

        ///  Example 6:
        System.out.println("Example 6: initializing a generic object that contains a booking object");

        Booking newBookingOne =  new Booking(UUID.randomUUID(),

                new User(UUID.randomUUID(), "Barry", "LeWhite"),

                new Car("123_1", new BigDecimal("89.00"), Brand.BMW, FuelType.ELECTRIC),

                LocalDateTime.now());

        GenericClass<Booking> bookingGenericClass = new GenericClass<>(newBookingOne);
        System.out.println(bookingGenericClass);
        System.out.println();

        ///  Example 7:
        System.out.println("Example 7: comparing to generic objects for equality");

        Car mercedesCopy = new Car("123_5",
                new BigDecimal("109.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        System.out.println(mercedes);
        System.out.println(mercedesCopy);

        System.out.println("mercedes and mercedesCopy generic object are equal: " + mercedes.equals(mercedesCopy));
        System.out.println();


        ///  Example 8:
        System.out.println("Example 8: comparing to generic objects for inequality");

        Car mercedesTwo = new Car("123_4",
                new BigDecimal("109.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        System.out.println(mercedes);
        System.out.println(mercedesTwo);

        System.out.println("mercedes and mercedesTwo generic objects are equal: " + mercedes.equals(mercedesTwo));

    }
}
