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
                "Leblond"));
    }

    @Override
    public boolean addUser(User user) {

        if (this.numberOfUsers >= this.userDAO.length) {
            return false;
        }

        // Store user at the current pointer and increment the index for the next addition
        this.userDAO[this.numberOfUsers] = user;
        this.numberOfUsers++;

        return true;
    }

    @Override
    public boolean updateUser(User user) {

        UUID userId = user.getUserId();
        boolean userFound = false;

        // Search up to numberOfUsers for a matching UUID
        for (int i = 0; i < this.numberOfUsers; i++) {

            User currentUser = this.userDAO[i];

            // If found, replace the old user object with the new data
            if (currentUser != null && currentUser.getUserId().equals(userId)) {

                this.userDAO[i] = user;

                userFound = true;

                // Stop searching once update is complete
                break;
            }
        }

        return userFound;
    }

    @Override
    public boolean removeUser(User user) {

        UUID userId = user.getUserId();

        boolean userFound = false;

        // Locate the user to be removed up to the numberOfUsers
        for (int i = 0; i < this.numberOfUsers; i++) {

            if (userDAO[i] != null && userId.equals(userDAO[i].getUserId())){

                // Shift all subsequent elements one position to the left to fill the hole
                for (int j = i; j < this.numberOfUsers - 1; j++) {

                    userDAO[j] = userDAO[j + 1];
                }

                // Nullify the last position
                userDAO[numberOfUsers - 1] = null;

                // Decrement nextAvailableIndex
                numberOfUsers--;

                userFound = true;

                // Exit loop after successful removal and shift
                break;
            }

        }

        return userFound;
    }

    @Override
    public  User[] getUsers() {

        // Returns a trimmed copy containing only existing users to avoid returning null slots
        return Arrays.copyOf(this.userDAO,this.numberOfUsers);
    }

    @Override
    public User getUserById(UUID userId) {

        // Iterate up to numberOfUsers to find a matching ID
        for (int i = 0; i < numberOfUsers; i++) {
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

        for (int i = 0; i < userDAO.length; i++) {
                userDAO[i] = null;
            }

        // Reset the availability pointer back to the start
        this.numberOfUsers = 0;
    }

    @Override
    public void displayAllUsers() {

        // Print names only for active slots
        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println(userDAO[i].getName() + " " + userDAO[i].getLastName());
        }
    }

}
