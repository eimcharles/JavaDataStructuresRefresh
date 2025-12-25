package dataStructures.arrayList.exerciseOne.user;

import dataStructures.arrayList.exerciseOne.user.dao.ListUserDAO;

import java.util.List;
import java.util.UUID;

public class UserExample {

    public static void main(String[] args) {

        ListUserDAO listUserDAO = new ListUserDAO();

        ///  Question 1
        System.out.println("Question 1: get all users");
        List<User> allUser = listUserDAO.getUsers();
        allUser.forEach(System.out::println);
        System.out.println();

        ///  Question 2
        System.out.println("Question 2: get the number of users");
        System.out.println("The number of users registered in the system is: " + listUserDAO.getNumberOfUsers());
        listUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 3
        System.out.println("Question 3: clear the number of users");
        listUserDAO.clearListUserDAO();

        System.out.println("The number of users registered in the system is: " + listUserDAO.getNumberOfUsers());
        listUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 4
        System.out.println("Question 4: add user");
        User charles = new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer");


        User Jerry = new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                "Jerry",
                "LeBlond");


        listUserDAO.addUser(charles);
        listUserDAO.addUser(Jerry);

        System.out.println("The number of users registered in the system is: " + listUserDAO.getNumberOfUsers());
        listUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 5
        System.out.println("Question 5: remove user");
        listUserDAO.removeUser(charles);

        System.out.println("The number of users registered in the system is: " + listUserDAO.getNumberOfUsers());
        listUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 6
        System.out.println("Question 6: update user");
        User jerryToUpdateByID = listUserDAO.getUserById(Jerry.getUserId());
        System.out.println("Prior id to update: " + jerryToUpdateByID.getName() + " "  + jerryToUpdateByID.getLastName());

        jerryToUpdateByID.setLastName("Doodle");
        listUserDAO.updateUser(jerryToUpdateByID);

        System.out.println("After id updated: "  + jerryToUpdateByID.getName()  + " "  + jerryToUpdateByID.getLastName());
        listUserDAO.displayAllUsers();
        System.out.println();

        ///  Question 7
        System.out.println("Question 7: get user by id");
        User jerryByID = listUserDAO.getUserById(jerryToUpdateByID.getUserId());
        System.out.println(jerryByID);
        System.out.println();

    }
}
