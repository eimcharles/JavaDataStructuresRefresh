package dataStructures.arrays.exerciseOne.user.dao;

import dataStructures.arrays.exerciseOne.exception.UserNotFoundException;
import dataStructures.arrays.exerciseOne.user.User;

import java.util.Arrays;
import java.util.UUID;

/**
 *      ArrayUserDAO is a Data Access Object (DAO)
 *      class for managing User objects,
 *      it implements the UserDAO contract.
 *
 *      This implementation stores and manages users using arrays.
 */

public class ArrayUserDAO implements UserDAO {

    private final User[] userDAO;
    private int numberOfUsers = 0;
    private static final int MAX_CAPACITY_OF_USERS = 5;

    public ArrayUserDAO() {

        this.userDAO = new User[MAX_CAPACITY_OF_USERS];

        addUser(new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer"));

        addUser(new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                "Jerry",
                "LeBlond"));
    }

    @Override
    public void addUser(User user) {

        // numberOfUsers >= max storage available
        if (this.numberOfUsers >= this.userDAO.length) {
            throw new IllegalStateException(String.format("No more available space to add users"));
        }

        // Store user at the current pointer and increment the index for the next addition
        this.userDAO[this.numberOfUsers] = user;
        this.numberOfUsers++;
    }

    @Override
    public void updateUser(User user) {

        // User to be updated by id
        UUID userId = user.getUserId();

        // Search up to numberOfUsers for a matching UUID
        for (int i = 0; i < this.numberOfUsers; i++) {

            // Placeholder for the updated object
            User currentUser = this.userDAO[i];

            // If found, replace the old user object with the new data
            if (currentUser != null && currentUser.getUserId().equals(userId)) {

                // Assign the passed used to the Placeholder
                this.userDAO[i] = user;

                // Stop searching once update is complete
                return;
            }
        }

        // user not found
        throw new UserNotFoundException(userId);
    }

    @Override
    public void removeUser(User user) {

        // User to be removed by id
        UUID userId = user.getUserId();

        // Locate the user to be removed up to the numberOfUsers
        for (int i = 0; i < this.numberOfUsers; i++) {

            // if the current slot is not empty and matches the ID
            if (userDAO[i] != null && userId.equals(userDAO[i].getUserId())){

                // Shift all subsequent elements one position to the left to fill the hole
                for (int j = i; j < this.numberOfUsers - 1; j++) {

                    userDAO[j] = userDAO[j + 1];
                }

                // Nullify the last position - duplicate
                userDAO[this.numberOfUsers - 1] = null;

                // Decrement numberOfUsers
                this.numberOfUsers--;

                // Exit loop after successful removal and shift
                return;
            }

        }

        // user not found
        throw new UserNotFoundException(userId);
    }

    @Override
    public  User[] getUsers() {

        // Return an empty array
        if (this.userDAO == null){
            return new User[0];
        }

        // Returns a trimmed copy containing only existing users to avoid returning null slots
        return Arrays.copyOf(this.userDAO,this.numberOfUsers);
    }

    @Override
    public User getUserById(UUID userId) {

        // UUID check
        if (userId == null){
            throw new IllegalArgumentException(String.format("UUID userId cannot be null"));
        }

        // Iterate up to numberOfUsers to find a matching ID
        for (int i = 0; i < this.numberOfUsers; i++) {
            if (userId.equals(userDAO[i].getUserId())){
                return userDAO[i];
            }
        }

        throw new UserNotFoundException(userId);
    }

    @Override
    public int getNumberOfUsers() {

        // Return the number of registered users
        return this.numberOfUsers;
    }

    @Override
    public void clearArrayUserDAO() {

        // No users to clear
        if (numberOfUsers == 0) {
            return;
        }

        // Nullify up to numberOfUsers
        for (int i = 0; i < numberOfUsers; i++) {
                userDAO[i] = null;
            }

        // Reset the numberOfUsers availability pointer back to the start
        this.numberOfUsers = 0;
    }

    @Override
    public void displayAllUsers() {

        // No users
        if (numberOfUsers == 0) {
            return;
        }

        // Print names only for active user slots
        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println(userDAO[i].getName() + " " + userDAO[i].getLastName());
        }
    }

}
