package generics.exerciseOne;

import dataStructures.arrayList.exerciseOne.user.User;
import dataStructures.arrayList.exerciseTwo.car.Brand;
import dataStructures.arrayList.exerciseTwo.car.Car;
import dataStructures.arrayList.exerciseTwo.car.FuelType;

import java.math.BigDecimal;
import java.util.UUID;

public class ExampleTwo {

    public static void main(String[] args) {

        ///  Example 1:
        System.out.println("Example 1: null multiparameter object");
        MultiParameterGenericClass<Object, Object> multiParameterGenericNullObject =
                new MultiParameterGenericClass<>();

        System.out.println(multiParameterGenericNullObject);
        System.out.println();

        ///  Example 2:
        System.out.println("Example 2: initializing a multiparameter generic object");

        User charles = new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer");

        Car mercedes = new Car("123_5",
                new BigDecimal("109.00"), Brand.MERCEDES, FuelType.ELECTRIC);


        MultiParameterGenericClass<User, Car> multiParameterGenericObject =
                new MultiParameterGenericClass<>(charles, mercedes);

        System.out.println(multiParameterGenericObject);
        System.out.println();


        ///  Example 3:
        System.out.println("Example 3: comparing two generic multiparameter objects for equality");

        User charlesCopy = new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer");

        Car mercedesCopy = new Car("123_5",
                new BigDecimal("109.00"), Brand.MERCEDES, FuelType.ELECTRIC);


        MultiParameterGenericClass<User, Car> multiParameterGenericObjectCopy =
                new MultiParameterGenericClass<>(charlesCopy, mercedesCopy);

        System.out.println(multiParameterGenericObject);
        System.out.println(multiParameterGenericObjectCopy);

        System.out.println("multiParameterGenericObject and multiParameterGenericObjectCopy generic object are equal: "
                + multiParameterGenericObject.equals(multiParameterGenericObjectCopy));

        System.out.println();


        ///  Example 4:
        System.out.println("Example 4: comparing two generic multiparameter objects for inequality");

        User bobby = new User(UUID.randomUUID(),
                "Bobby",
                "Johnson");

        Car volkswagen = new Car("123_3",
                new BigDecimal("69.00"),
                Brand.VOLKSWAGEN, FuelType.ELECTRIC);


        MultiParameterGenericClass<User, Car> differentMultiParameterGenericObject =
                new MultiParameterGenericClass<>(bobby, volkswagen);

        System.out.println(multiParameterGenericObject);
        System.out.println(differentMultiParameterGenericObject);

        System.out.println("multiParameterGenericObject and differentMultiParameterGenericObject generic object are equal: "
                + multiParameterGenericObject.equals(differentMultiParameterGenericObject));
        System.out.println();

    }

}
