package generics.exerciseTwo;

import java.util.Arrays;
import java.util.List;

public class ExampleTwo {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<Number> numberList = Arrays.asList(1.1, 2, 3, 4.4);

        ///  Example 1
        System.out.println("Example 1: printing Integers using upper bounded wildcards");
        printNumbers(intList);
        System.out.println();

        ///  Example 2
        System.out.println("Example 2: printing Doubles using upper bounded wildcards");
        printNumbers(doubleList);
        System.out.println();

        ///  Example 3
        System.out.println("Example 3: printing Numbers using upper bounded wildcards");
        printNumbers(numberList);
        System.out.println();

        ///  Example 4
        System.out.println("Example 4: sum of Integers using upper bounded wildcards");
        System.out.println("Total: " + sumOfNumberList(intList));
        System.out.println();

        ///  Example 5
        System.out.println("Example 5: sum of Doubles using upper bounded wildcards");
        System.out.println("Total: " + sumOfNumberList(doubleList));
        System.out.println();

        ///  Example 6
        System.out.println("Example 6: sum of Number using upper bounded wildcards");
        System.out.println("Total: " + sumOfNumberList(numberList));
        System.out.println();

    }

    /**
     *      Wildcards (?): Upper bounds (ceiling)
     *
     *      Restriction: The caller can only pass a List of 'Type' Number
     *                   or one of its subclasses.
     *
     *      Wildcards can ONLY have ONE bound: List<? extends Number>
     *
     *      PECS: Producer Extends | Consumer Super
     *
     *      The passed List<? extends Number> list
     *      is a Producer, can be pure, almost always impure:
     *
     *              Instantiate Objects
     *              Data retrieval
     *              Deferred execution
     * */

    static void printNumbers(List<? extends Number> list) {

        list.forEach( e -> {

            System.out.println(e.getClass().getSimpleName() + "\t\t" + e);

        });

    }

    static double sumOfNumberList(List<? extends Number> list) {

        double sum = 0.0;

        for (Number n : list) {

            /**
             *      We can call .doubleValue() because we guaranteed
             *      the list contains Numbers or its subclasses.
             * */

            sum += n.doubleValue();
        }

        return sum;
    }

}
