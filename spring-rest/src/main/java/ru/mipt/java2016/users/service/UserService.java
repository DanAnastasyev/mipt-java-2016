package ru.mipt.java2016.users.service;

import java.util.List;
import ru.mipt.java2016.users.model.User;


public interface UserService {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(User user);

}
