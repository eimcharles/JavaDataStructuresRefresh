package dataStructures.arrayList.exerciseOne.user.dao;

import dataStructures.arrayList.exerciseOne.user.User;

import java.util.UUID;

/**
 *      UserDAO defines the contract for all data
 *      access operations related to User entities
 * */

public interface UserDAO {

    ///  TODO: CONVERT CLASS TO USE ARRAY LISTS

    void addUser(User user);

    void updateUser(User user);

    void removeUser(User user);

    User[] getUsers();

    User getUserById(UUID id);

    int getNumberOfUsers();

    void clearArrayUserDAO();

    void displayAllUsers();

}
