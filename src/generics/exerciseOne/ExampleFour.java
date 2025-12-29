package generics.exerciseOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ExampleFour {

    public static void main(String[] args) {

        int count;

        ///  Classes that implement comparable
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
     *      Bounded type parameters: Upper Bound
     *
     *      Problem:
     *
     *      How can I ensure that the generic objects being
     *      passed in are capable of being compared to each other?
     *
     *      Solution:
     *
     *      I will accept any type T, but ONLY if
     *      that type has IMPLEMENTED the Comparable interface
     *      (e.g., the Integer or String class).
     *
     *      The upper bound restricts the "unlimited" nature of generics
     *      to a specific family of classes that know how to compare themselves.
     *
     *      Bounded Type Parameters (<T extends Comparable <T> >) are used when
     *      you need to refer to the exact same type multiple times in
     *      a method.
     *
     *      <T> : The Type Parameter -  method uses a placeholder 'T'.
     *      T[] : The input parameter - array containing elements of type 'T'.
     *      n.compareTo(number) - returns an integer
     * */

    static <T extends Comparable<T> > int countGreaterThan(T[] elementTypeArray, T number) {

        int count = 0;
        for (T n : elementTypeArray) {

            ///  n.compareTo() references Comparable <T> in the method
            if (n.compareTo(number) > 0){
                count++;
            }
        }
        return count;
    }

    static <T extends Comparable<T> > int countGreaterThan(List<T> elementTypeList, T number) {

        int count = 0;
        for (T n : elementTypeList) {

            ///  n.compareTo() references Comparable <T> in the method
            if (n.compareTo(number) > 0){
                count++;
            }
        }
        return count;
    }

}
