package generics.exerciseTwo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExampleOne {

    public static void main(String[] args) {

        ///  Example 1
        System.out.println("Example 1:");
        print(Arrays.asList(1,2, new Date(), true, false));
        System.out.println();

        ///  Example 2
        System.out.println("Example 2:");
        print(Arrays.asList(1.0,2.0,3.0,4.0,5.0));
        System.out.println();

        ///  Example 3
        System.out.println("Example 3:");
        print(Arrays.asList("1.0","2.0","3.0","4.0","5.0"));
        System.out.println();

        ///  Example 4
        System.out.println("Example 4:");
        print(Arrays.asList(UUID.randomUUID(), UUID.randomUUID()));
        System.out.println();

    }

    /**
     *      Wildcards (?) represent an UNKNOWN type.
     *
     *      Use ? (Wildcard) when:
     *      - The method logic is independent of the type: e.g., printing, counting, or clearing a list.
     *      - Want maximum flexibility for the caller.
     *      - Only "consuming" (reading) the data as an Object.
     *
     *      Use T (Type Parameter) when:
     *      - Need a relationship: e.g., the return type must match the input type.
     * */

    static void print(List<?> list) {

        list.forEach( e -> {

            System.out.println(e.getClass().getSimpleName() + "\t\t" + e);

        });

    }

}
