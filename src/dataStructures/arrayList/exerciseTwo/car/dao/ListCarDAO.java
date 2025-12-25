package dataStructures.arrayList.exerciseTwo.car.dao;

import dataStructures.arrayList.exerciseTwo.car.Brand;
import dataStructures.arrayList.exerciseTwo.car.Car;
import dataStructures.arrayList.exerciseTwo.car.FuelType;
import dataStructures.arrayList.exerciseTwo.exception.CarNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *      ListCarDAO is a Data Access Object (DAO)
 *      class for managing Car objects,
 *      it implements the CarDAO contract.
 *
 *      This implementation stores and manages cars using ArrayLists.
 */

public class ListCarDAO implements CarDAO {

    private final List<Car> carDAO;

    public ListCarDAO() {

        this.carDAO = new ArrayList<>();

        // Available for booking
        addCar(new Car("123_1", new BigDecimal("89.00"), Brand.BMW, FuelType.ELECTRIC));
        addCar(new Car("123_2", new BigDecimal("79.00"), Brand.BMW, FuelType.GASOLINE));
        addCar(new Car("123_3", new BigDecimal("69.00"), Brand.VOLKSWAGEN, FuelType.ELECTRIC));

        // Car booked in system
        addCar(new Car("123_4", new BigDecimal("49.00"), Brand.HONDA, FuelType.ELECTRIC));

    }

    @Override
    public List<Car> getCars() {

        // Return an empty arrayList
        if (this.carDAO == null || this.carDAO.isEmpty()){
            return new ArrayList<>();
        }

        // Returns a new list containing the same cars.
        return new ArrayList<>(this.carDAO);
    }

    @Override
    public void addCar(Car car) {

        // if not null, add
        if (car != null){
            carDAO.add(car);
        }
    }

    @Override
    public void updateCar(Car car) {

        // Car to be cancelled registration number
        String registrationNumber = car.getRegistrationNumber();

        for (int i = 0; i < this.carDAO.size(); i++) {

            // Placeholder for the updated object
            Car currentCar = this.carDAO.get(i);

            // Match the currentCar car with the registration number
            if (currentCar != null && currentCar.getRegistrationNumber().equals(registrationNumber)) {

                // Replace the old object reference with the new
                this.carDAO.set(i, car);

                // Stop searching once update is complete
                return;
            }
        }

        // Car not found
        throw new CarNotFoundException(registrationNumber);
    }

    @Override
    public void displayAllCars() {

        // No cars to display
        if (carDAO.isEmpty()) {
            return;
        }

        // Java Streams
        carDAO.forEach(System.out::println);
    }

}
