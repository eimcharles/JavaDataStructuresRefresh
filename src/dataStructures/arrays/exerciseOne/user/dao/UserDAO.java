package dataStructures.arrays.exerciseOne.user.dao;

import dataStructures.arrays.exerciseOne.user.User;

import java.util.UUID;

/**
 *      UserDAO defines the contract for all data
 *      access operations related to User entities
 * */

public interface UserDAO {

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean removeUser(User user);

    User[] getUsers();

    User getUserById(UUID id);

    int getNumberOfUsers();

    void clearArrayUserDAO();

    void displayAllUsers();

}
