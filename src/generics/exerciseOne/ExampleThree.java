package generics.exerciseOne;

import dataStructures.arrayList.exerciseTwo.car.Brand;
import dataStructures.arrayList.exerciseTwo.car.Car;
import dataStructures.arrayList.exerciseTwo.car.FuelType;
import dataStructures.arrays.exerciseOne.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ExampleThree {

    public static void main(String[] args) {

        User[] userArray = {

                new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                        "Charles",
                        "Eimer"),

                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                        "Jerry",
                        "LeBlond")

        };

        List<Car> carsList = new ArrayList<>(

                // Mutable list
                Arrays.asList(

                        new Car("123_1", new BigDecimal("89.00"), Brand.BMW, FuelType.ELECTRIC),
                        new Car("123_2", new BigDecimal("79.00"), Brand.BMW, FuelType.GASOLINE),
                        new Car("123_3", new BigDecimal("69.00"), Brand.VOLKSWAGEN, FuelType.ELECTRIC),
                        new Car("123_4", new BigDecimal("49.00"), Brand.HONDA, FuelType.ELECTRIC)
                ));


        ///  Example 1:
        System.out.println("Example 1: generic method for array of any type");
        displayElements(userArray);
        System.out.println();

        ///  Example 2:
        System.out.println("Example 2: generic method for arrayList of any type");
        displayElements(carsList);
        System.out.println();

    }

    /**
     *      <T> : The Type Parameter -  method uses a placeholder 'T'.
     *      T[] : The input parameter - array containing elements of type 'T'.
     */

    static <T> void displayElements(T[] elementTypeArray){

        for (T type : elementTypeArray) {
            System.out.println(type.getClass() + "\t" + type);
        }
    }

    /**
     *      <T> : The Type Parameter -  method uses a placeholder 'T'.
     *      List<T> : The input parameter - arraylist containing elements of type 'T'.
     */

    static <T> void displayElements(List<T> elementTypeList){

        for (T type : elementTypeList) {
            System.out.println(type.getClass() + "\t" + type);
        }
    }
}
