package dataStructures.arrays.exerciseOne.user;

import dataStructures.arrays.exerciseOne.user.dao.ArrayUserDAO;

import java.util.Arrays;
import java.util.UUID;

public class UserExample {

    public static void main(String[] args) {

        ArrayUserDAO arrayUserDAO = new ArrayUserDAO();

        ///  Question 1
        System.out.println("Question 1: get all users");
        System.out.println(Arrays.toString(arrayUserDAO.getUsers()));
        System.out.println();

        ///  Question 2
        System.out.println("Question 2: get the number of users");
        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 3
        System.out.println("Question 3: clear the number of users");
        arrayUserDAO.clearArrayUserDAO();

        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 4
        System.out.println("Question 4: add user");

        User charles = new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer");


        User Jerry = new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                "Jerry",
                "LeBlond");


        arrayUserDAO.addUser(charles);
        arrayUserDAO.addUser(Jerry);

        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 5
        System.out.println("Question 5: remove user");
        arrayUserDAO.removeUser(charles);

        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 6
        System.out.println("Question 6: update user");
        User jerryToUpdateByID = arrayUserDAO.getUserById(Jerry.getUserId());
        System.out.println("Prior id to update: " + jerryToUpdateByID.getName() + " "  + jerryToUpdateByID.getLastName());

        jerryToUpdateByID.setLastName("Doodle");
        arrayUserDAO.updateUser(jerryToUpdateByID);

        System.out.println("After id updated: "  + jerryToUpdateByID.getName()  + " "  + jerryToUpdateByID.getLastName());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 7
        System.out.println("Question 7: get user by id");
        User jerryById = arrayUserDAO.getUserById(jerryToUpdateByID.getUserId());
        System.out.println(jerryById);
        System.out.println();

    }
}
