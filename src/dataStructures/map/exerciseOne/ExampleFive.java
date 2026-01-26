package dataStructures.map.exerciseOne;

import java.util.HashMap;
import java.util.Map;

public class ExampleFive {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 3, 3, 4};

        ///  Example 5:
        System.out.println("Example four: finding common integer key values and the common frequency of repeated integers in two arrays");
        elementFrequencyMap(arr1, arr2);
        System.out.println();
    }

    public static void elementFrequencyMap(int[] intArrayOne, int[] intArrayTwo) {

        /// Frequency values for integers in arrayOne
        Map<Integer, Integer> map1 = new HashMap<>();

        /// Frequency values for integers in arrayTwo
        Map<Integer, Integer> map2 = new HashMap<>();

        /// Common integer values from both arrayOne and arrayTwo
        Map<Integer, Integer> commonMap = new HashMap<>();

        for (int num : intArrayOne) {
            Integer countOne = map1.getOrDefault(num, 0);
            map1.put(num, countOne + 1);
        }

        for (int num : intArrayTwo) {
            Integer countTwo = map2.getOrDefault(num, 0);
            map2.put(num, countTwo + 1);
        }

        ///  Check the contents of map1
        System.out.println("Integer value frequency in map1");
        map1.forEach((key,valueFrequency) ->
                System.out.println("Integer value: " + key + "\tfrequency in arrayOne: " + valueFrequency));

        System.out.println();

        ///  Check the contents of map2
        System.out.println("Integer value frequency in map2");
        map2.forEach((key,valueFrequency) ->
                System.out.println("Integer value: " + key + "\tfrequency in arrayTwo: " + valueFrequency));

        ///  Checking for matching keys, key intersection
        map1.forEach((key, valueFrequency) -> {
            if (map2.containsKey(key)) {

                /**
                 *      Adding the common integer frequency
                 *      counts to HashMap commonMap,
                 *      value intersection.
                 *
                 *      The integer number frequency is
                 *      limited by the element that has
                 *      the smaller amount
                 * */

                commonMap.put(key, Math.min(valueFrequency, map2.get(key)));

            }
        });

        System.out.println();
        System.out.println("Common Integer keys and frequency values");

        ///  Check the contents of commonMap
        commonMap.forEach((key,valueFrequency) ->
                System.out.println("Integer value: " + key + "\tcommon frequency in both arrays: " + valueFrequency));
    }

}
