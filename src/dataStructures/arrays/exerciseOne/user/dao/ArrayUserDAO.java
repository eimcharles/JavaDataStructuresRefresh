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

    public ArrayUserDAO() {

        this.userDAO = new User[]

                {

                new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"), "Charles", "Eimer"),
                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"), "Jerry", "Leblond"),

        };
    }

    @Override
    public  User[] getUsers() {
        return Arrays.copyOf(this.userDAO,this.userDAO.length);
    }

    @Override
    public User getUserById(UUID id) {
        for (User user: this.userDAO){
            if (user.getUserId().equals(id)){
                return user;
            }
        }

        throw new UserNotFoundException(id);
    }

    @Override
    public boolean addUserById(UUID id) {

        ///  Exercise TODO

        return false;
    }

    @Override
    public boolean updateUserById(UUID id) {

        ///  Exercise TODO

        return false;
    }

    @Override
    public boolean removeUserById(UUID id) {

        ///  Exercise TODO

        return false;
    }

    @Override
    public int getNumberOfUsers() {

        ///  Exercise TODO

        return 0;
    }

    @Override
    public void clearArrayUserDAO() {

        ///  Exercise TODO

    }
}
