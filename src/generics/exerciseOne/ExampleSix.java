package generics.exerciseOne;


import java.math.BigDecimal;

public class ExampleSix {

    public static void main(String[] args) {

        int count;

        ///  Classes that implement comparable and comparable
        Integer[] integerArray = {1, 5, 10};
        Double[] doubleArray = {1.1, 5.5, 10.2};
        Long[] longArray = {100L, 500L, 1000L};

        BigDecimal[] bigDecimalArray = {
                new BigDecimal("1.05"),
                new BigDecimal("2.10"),
                new BigDecimal("3.15")
        };


        ///  Number doesn't implement comparable - countGreaterThan() compile time error
        Number[] numberArray = {1, 1.0, 1.1};

        ///  Example 1:
        System.out.println("Example 1: countGreaterThan() using an Integer array that extends Number and implements Comparable interface");
        count = countGreaterThan(integerArray, 3);
        System.out.println(count);
        System.out.println();

        ///  Example 2:
        System.out.println("Example 2: countGreaterThan() using an Double array that extends Number and implements Comparable interface");
        count = countGreaterThan(doubleArray, 3.0);
        System.out.println(count);
        System.out.println();

        ///  Example 3:
        System.out.println("Example 3: countGreaterThan() using an Long array that extends Number and implements Comparable interface");
        count = countGreaterThan(longArray, 300L);
        System.out.println(count);
        System.out.println();

        ///  Example 4:
        System.out.println("Example 4: countGreaterThan() using an Big Decimal array that extends Number and implements Comparable interface");
        count = countGreaterThan(bigDecimalArray, new BigDecimal("2.00"));
        System.out.println(count);
        System.out.println();
    }

    /**
     *      Multiple Bounds: Upper bounds with intersections
     *
     *      The syntax follows this pattern: <T extends Class & Interface1 & Interface2>
     *
     *      Class First: If a class is part of the bound,
     *      it MUST be declared first otherwise it's a compile error.
     *
     *      Intersection (&): The type 'T' must satisfy ALL bounds
     *
     *      Type passed must extend the Number class
     *      Type passed must implement the Comparable interface.
     * */

    static <T extends Number & Comparable<T>> int countGreaterThan(T[] elementTypeArray, T number) {

        int count = 0;
        for (T n : elementTypeArray) {
            if (n.compareTo(number) > 0){
                count++;
            }
        }
        return count;
    }

}

