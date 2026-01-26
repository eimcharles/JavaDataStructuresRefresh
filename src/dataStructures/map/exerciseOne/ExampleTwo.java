package dataStructures.map.exerciseOne;

import java.util.Map;

public class ExampleTwo {

    public static void main(String[] args) {

        Map<Integer, String> stringMapOne = Map.of(
                1, "Apple",
                2, "Banana",
                3, "Cherry"
        );

        Map<Integer, String> stringMapTwo = Map.of(
                1, "Apple",
                2, "Banana",
                3, "Cherry"
        );

        Map<Integer, String> stringMapThree = Map.of(
                1, "Purple",
                2, "Green",
                3, "Yellow"
        );

        boolean isEqual;

        ///  Example 1:
        System.out.println("Example one: checking if two maps are equal");
        isEqual = mapsAreEqual(stringMapOne, stringMapTwo);

        System.out.println("Maps are equal: " + isEqual);
        System.out.println();

        ///  Example 2:
        System.out.println("Example two: checking if two maps are equal");
        isEqual = mapsAreEqual(stringMapOne, stringMapThree);

        System.out.println("Maps are equal: " + isEqual);
        System.out.println();

    }

    public static boolean mapsAreEqual(Map<Integer, String> mapOne, Map<Integer, String> mapTwo) {
        return mapOne.equals(mapTwo);
    }

}
