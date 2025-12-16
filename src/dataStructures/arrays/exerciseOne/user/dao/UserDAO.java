package dataStructures.arrays.exerciseOne.user.dao;

import dataStructures.arrays.exerciseOne.user.User;

import java.util.UUID;

/**
 *      UserDAO defines the contract for all data
 *      access operations related to User entities
 * */

public interface UserDAO {

    User[] getUsers();

    User getUserById(UUID id);

    boolean addUserById(UUID id);

    boolean updateUserById(UUID id);

    boolean removeUserById(UUID id);

    int getNumberOfUsers();

    void clearArrayUserDAO();

}
