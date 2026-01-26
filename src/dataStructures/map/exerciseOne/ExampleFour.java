package dataStructures.map.exerciseOne;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExampleFour {

    public static void main(String[] args) {

        String string = "racecar";

        ///  Example 4:
        System.out.println("Example two: finding the first non-repeating character in a string");
        char firstNonRepeating = findFirstNonRepeatingCharacter(string);
        System.out.println();

        System.out.println("First non-repeating character in the string is: " + firstNonRepeating);
        System.out.println();

    }

    public static Character findFirstNonRepeatingCharacter(String string){

        /// LinkedHashMap remembers the order in which items are added (hashed).
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        ///  Break the String into an array of Char values
        char[] characters = string.toCharArray();

        ///  Count the occurrence of each Char value by adding it to LinkedHashMap
        for (int i = 0; i < characters.length; i++) {
            int currentCount = charCountMap.getOrDefault(characters[i], 0);
            charCountMap.put(characters[i], currentCount + 1);
        }

        ///  Display the contents of the LinkedHashMap
        charCountMap.forEach((key,valueFrequency) ->
                System.out.println("Char value: " + key + "\tfrequency of char values in array: " + valueFrequency));

        ///  Finding the first non-repeating character from the LinkedHashMap
        return charCountMap
                ///  Convert the LinkedHashMap to an Entry Set.
                ///  Entry sets are collections that hold key, value pairs as a single unit.
                .entrySet()
                .stream()
                ///  Filter each Entry set by checking if the value's frequency = 1
                .filter(entry -> entry.getValue() == 1)
                ///  Extract the key character value from the entry set
                .map(Map.Entry::getKey)
                ///  Stop as soon as you find the first character with a frequency of one
                .findFirst()
                .orElse(null);

    }
}
