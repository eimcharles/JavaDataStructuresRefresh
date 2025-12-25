package dataStructures.arrayList.exerciseTwo.car.dao;


import dataStructures.arrayList.exerciseTwo.car.Car;

import java.util.List;

/**
 *      CarDAO defines the contract for all data
 *      access operations related to Car entities
 * */

public interface CarDAO {

    void addCar(Car car);

    void updateCar(Car car);

    List<Car> getCars();

    void displayAllCars();

}
