package generics.exerciseOne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ExampleFive {

    public static void main(String[] args) {

        int count;

        ///  Classes that implement comparable and serializable
        Integer[] integerArray = {1, 5, 10};
        Double[] doubleArray = {1.1, 5.5, 10.2};

        List<UUID> uuidList = new ArrayList<>(

                Arrays.asList(
                        UUID.fromString("11111111-aaaa-bbbb-cccc-dddddddddddd"),
                        UUID.fromString("22222222-aaaa-bbbb-cccc-dddddddddddd"),
                        UUID.fromString("33333333-aaaa-bbbb-cccc-dddddddddddd")
                )
        );

        ///  Example 1:
        System.out.println("Example 1: countGreaterThan() using an Integer array");
        count = countGreaterThan(integerArray, 3);
        System.out.println(count);
        System.out.println();

        ///  Example 2:
        System.out.println("Example 2: countGreaterThan() using an Double array");
        count = countGreaterThan(doubleArray, 3.1);
        System.out.println(count);
        System.out.println();

        ///  Example 3:
        System.out.println("Example 3: countGreaterThan() using an UUID arrayList");
        count = countGreaterThan(uuidList, UUID.fromString("11111111-aaaa-bbbb-cccc-dddddddddddd"));
        System.out.println(count);
        System.out.println();

    }

    /**
     *      Multiple Bounds: Upper bounds
     *
     *      The syntax follows this pattern: <T extends Class & Interface1 & Interface2>
     *
     *      Class First: If a class is part of the bound,
     *      it MUST be declared first otherwise it's a compile error.
     *
     *      Intersection (&): The type 'T' must satisfy ALL bounds
     *
     *      Type Erasure: At runtime, the compiler replaces 'T' with the leftmost bound.
     * */

    static <T extends Comparable<T> & Serializable > int countGreaterThan(T[] elementTypeArray, T number) {

        int count = 0;
        for (T n : elementTypeArray) {
            if (n.compareTo(number) > 0){
                count++;
            }
        }
        return count;
    }

    static <T extends Comparable<T> & Serializable > int countGreaterThan(List<T> elementTypeList, T number) {

        int count = 0;
        for (T n : elementTypeList) {
            if (n.compareTo(number) > 0){
                count++;
            }
        }
        return count;
    }

}
