package dataStructures.arrayList.exerciseOne.user.dao;

import dataStructures.arrayList.exerciseOne.user.User;
import dataStructures.arrays.exerciseOne.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *      ListUserDAO is a Data Access Object (DAO)
 *      class for managing User objects,
 *      it implements the UserDAO contract.
 *
 *      This implementation stores and manages users using ArrayLists.
 */

public class ListUserDAO implements UserDAO {

    private final List<User> userDAO;

    public ListUserDAO() {

        userDAO = new ArrayList<>();

        addUser(new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"),
                "Charles",
                "Eimer"));

        addUser(new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"),
                "Jerry",
                "LeBlond"));
    }

    @Override
    public void addUser(User user) {

        // if not null, add
        if (user != null){
            userDAO.add(user);
        }

    }

    @Override
    public void updateUser(User user) {

        // User to be updated by id
        UUID userId = user.getUserId();

        for (int i = 0; i < this.userDAO.size(); i++) {

            // Placeholder for the updated object
            User currentUser = this.userDAO.get(i);

            // Match the currentUser with the user id
            if (currentUser != null && currentUser.getUserId().equals(userId)) {

                // Replace the old user object at index i with the new data
                this.userDAO.set(i, user);

                // Stop searching once update is complete
                return;
            }
        }

        // User not found
        throw new UserNotFoundException(userId);
    }

    @Override
    public void removeUser(User user) {

        // User to be removed by id
        UUID userId = user.getUserId();

        // Looks at every user 'u' and checks their ID specifically
        boolean removed = userDAO.removeIf(u -> u.getUserId().equals(userId));

        // User removed
        if (removed)
            return;

        // User not found
        throw new UserNotFoundException(userId);
    }

    @Override
    public List<User> getUsers() {

        // Return an empty arrayList
        if (this.userDAO == null || this.userDAO.isEmpty()){
            return new ArrayList<>();
        }

        // Returns a new list containing the same users.
        return new ArrayList<>(this.userDAO);
    }

    @Override
    public User getUserById(UUID userId) {

        // User check
        if (userId == null){
            throw new IllegalArgumentException(String.format("userId cannot be null"));
        }

        // Iterate to find a user with matching ID
        for (int i = 0; i < this.userDAO.size(); i++) {
            if (userId.equals(userDAO.get(i).getUserId())){
                return userDAO.get(i);
            }
        }

        // User not found
        throw new UserNotFoundException(userId);
    }

    @Override
    public int getNumberOfUsers() {

        // Return the number of registered users
        return userDAO.size();
    }

    @Override
    public void clearListUserDAO() {

        // No users to clear
        if (userDAO.isEmpty()) {
            return;
        }

        // Clear userDAO
        userDAO.clear();
    }

    @Override
    public void displayAllUsers() {

        // No users to display
        if (userDAO.isEmpty()) {
            return;
        }

        // Java Streams
        userDAO.forEach(System.out::println);
    }

}
