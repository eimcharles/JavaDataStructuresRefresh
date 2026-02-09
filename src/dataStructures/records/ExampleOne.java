package dataStructures.records;

import java.time.LocalDateTime;

public class ExampleOne {

    public static void main(String[] args) {

        UserData user = new UserData("Charles", "Eimer", LocalDateTime.now());
        System.out.println(user);

        UserData invalidUser = new UserData("", null, LocalDateTime.now());
        System.out.println(invalidUser);

        UserData invalidDate = new UserData("Eric", "Ericsson", null);
        System.out.println(invalidDate);

    }
}
