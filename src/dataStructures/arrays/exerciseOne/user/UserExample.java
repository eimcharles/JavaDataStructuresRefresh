package dataStructures.arrays.exerciseOne.user;

import dataStructures.arrays.exerciseOne.user.dao.ArrayUserDAO;

import java.util.Arrays;
import java.util.UUID;

public class UserExample {

    public static void main(String[] args) {

        ArrayUserDAO arrayUserDAO = new ArrayUserDAO();

        System.out.println("Question 1: get all users");
        System.out.println(Arrays.toString(arrayUserDAO.getUsers()));
        System.out.println();

        System.out.println("Question 2: get the number of users");
        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        System.out.println("Question 3: add a new user");
        boolean userAdded = arrayUserDAO.addUser(new User(UUID.fromString("8e397f1e-e7a4-4c39-8331-968a9ab3faef"), "Bobby", "Butch"));
        System.out.println("User has been added: " + userAdded);
        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        System.out.println("Question 4: update an existing user by id");
        boolean isUpdated = arrayUserDAO.updateUser(new User(UUID.fromString("8e397f1e-e7a4-4c39-8331-968a9ab3faef"), "Larry", "Butch"));
        System.out.println("User has been updated: " + isUpdated);
        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        System.out.println("Question 5: get a an existing user by id");
        User userById = arrayUserDAO.getUserById((UUID.fromString("8e397f1e-e7a4-4c39-8331-968a9ab3faef")));
        System.out.println("User by id user name: " + userById.getName());
        System.out.println();

        System.out.println("Question 6: remove a an existing user by id");
        boolean isRemoved = arrayUserDAO.removeUser(new User(UUID.fromString("8e397f1e-e7a4-4c39-8331-968a9ab3faef"), "Larry", "Butch"));
        System.out.println("User has been updated: " + isRemoved);
        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();
        System.out.println();

        System.out.println("Question 7: remove all users");
        arrayUserDAO.clearArrayUserDAO();
        System.out.println("The number of users registered in the system is: " + arrayUserDAO.getNumberOfUsers());
        arrayUserDAO.displayAllUsers();

    }
}
