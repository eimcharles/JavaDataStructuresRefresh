package dataStructures.arrayList.exerciseTwo.car.dao;


import dataStructures.arrayList.exerciseTwo.car.Car;

/**
 *      CarDAO defines the contract for all data
 *      access operations related to Car entities
 * */

public interface CarDAO {

    ///  TODO: CONVERT CLASS TO USE ARRAY LISTS

    Car[] getCars();

    void addCar(Car car);

    void updateCar(Car carToUpdate);

}
