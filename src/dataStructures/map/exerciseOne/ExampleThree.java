package dataStructures.map.exerciseOne;

import java.util.HashMap;
import java.util.Map;

public class ExampleThree {

    public static void main(String[] args) {

        int[] intArray = {2, 2, 2, 3, 3, 3, 4, 4, 4, 4};

        ///  Example 1:
        System.out.println("Example one: counting the frequency of integer in values in an array by storing them into a map");
        elementFrequencyMap(intArray);
        System.out.println();
    }

    public static void elementFrequencyMap(int[] intArray) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < intArray.length; i++) {

            /**
             *      getOrDefault checks if the
             *      value at intArray[i]
             *      is initially present in
             *      the MAP, if the value
             *      is present, it
             *      returns the count.
             *
             *      2 is not present -> return 0
             *      2 is present -> return 1
             */

            int currentCount = frequencyMap.getOrDefault(intArray[i], 0);

            /**
             *      Take the returned count
             *      for the given iteration
             *      and 1 for the value added
             *      to the frequencyMap
             * */

            frequencyMap.put(intArray[i], currentCount + 1);
        }

        frequencyMap.forEach((key,valueFrequency) ->
                System.out.println("Int value: " + key + "\tfrequency of int values in array: " + valueFrequency));

    }
}
