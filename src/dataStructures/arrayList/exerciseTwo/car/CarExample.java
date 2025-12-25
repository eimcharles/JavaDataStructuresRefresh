package dataStructures.arrayList.exerciseTwo.car;

import dataStructures.arrayList.exerciseTwo.car.dao.ListCarDAO;

import java.math.BigDecimal;
import java.util.List;

public class CarExample {

    public static void main(String[] args) {

        ListCarDAO listCarDAO = new ListCarDAO();

        ///  Question 1
        System.out.println("Question 1: get all cars");
        List<Car> allCars = listCarDAO.getCars();
        allCars.forEach(System.out::println);
        System.out.println();

        ///  Question 2
        System.out.println("Question 2: add car");

        Car mercedes = new Car("123_5",
                new BigDecimal("109.00"), Brand.MERCEDES, FuelType.ELECTRIC);

        listCarDAO.addCar(mercedes);
        listCarDAO.displayAllCars();
        System.out.println();

        ///  Question 3
        System.out.println("Question 3: update car");
        System.out.println("Prior to update: " + mercedes.getRentalPricePerDay() + " "  + mercedes.getFuelType());

        mercedes.setRentalPricePerDay(new BigDecimal("119.00"));
        mercedes.setFuelType(FuelType.GASOLINE);
        listCarDAO.updateCar(mercedes);

        System.out.println("After update: " + mercedes.getRentalPricePerDay() + " "  + mercedes.getFuelType());
        listCarDAO.displayAllCars();
        System.out.println();

    }
}
