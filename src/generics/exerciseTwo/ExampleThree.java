package generics.exerciseTwo;

import java.util.*;

public class ExampleThree {

    public static void main(String[] args) {

        ///  Mutable arrayLists
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Double> doubleList = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3));
        List<Number> numberList = new ArrayList<>(Arrays.asList(1.1, 2, 3, 4.4));
        List<Object> objectList = new ArrayList<>(Arrays.asList(true, false, new Date()));

        ///  Example 1
        System.out.println("Example 1: adding Integers, Double, Longs to a Number list using lower bounded wildcards");
        addNumberToList(numberList);
        printNumbers(numberList);
        System.out.println();

        ///  Example 2
        System.out.println("Example 2: adding Integers to a Integer list using lower bounded wildcards");
        addIntegersToList(intList);
        printNumbers(intList);
        System.out.println();

        ///  Example 3
        System.out.println("Example 3: adding Double to a Double list using lower bounded wildcards");
        addDoubleToList(doubleList);
        printNumbers(doubleList);
        System.out.println();

        ///  Example 4
        System.out.println("Example 4: adding Integers to a Object list using lower bounded wildcards");
        addIntegersToList(objectList);
        printNumbers(objectList);
        System.out.println();

        ///  Example 5
        System.out.println("Example 5: adding Doubles to a Object list using lower bounded wildcards");
        addDoubleToList(objectList);
        printNumbers(objectList);
        System.out.println();
    }

    /**
     *      Wildcards (?): Lower bounds (floor)
     *
     *      Restriction: The caller can only pass a List of
     *                   the 'Type' or its superclasses.
     *
     *      Wildcards can ONLY have ONE bound: List<? super Number>
     *
     *      PECS: Producer Extends | Consumer Super
     *
     *      List<? super Number> list is a
     *      Consumer: writes (add) data into a collection.
     */

    static void addNumberToList(List<? super Number> list) {

        /**
         *      We can safely add an Integer, Double, Long because the list is guaranteed
         *      to be a List of Number or its supertypes.
         */

        list.add(10);                                   // Integer
        list.add(3.14);                                 // Double
        list.add(100L);                                 // Long

    }

    static void addIntegersToList(List<? super Integer> list) {

        /**
         *      We can safely add an Integer because the list is guaranteed
         *      to be a List of Integer or its supertypes (Number or Object).
         */

        list.add(10);

    }


    static void addDoubleToList(List<? super Double> list) {

        /**
         *      We can safely add a Double because the list is guaranteed
         *      to be a List of Double or its supertypes (Number or Object).
         */

        list.add(10.0);

    }

    static void printNumbers(List<?> list) {

        list.forEach( e -> {

            System.out.println(e.getClass().getSimpleName() + "\t\t" + e);

        });

    }

}
