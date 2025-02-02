package app.service;

import app.model.User;

import java.util.List;

public interface UserServiceInt {
    List<User> getUsers();

    User getUser(int id);

    void saveUser (User user);

    void updateUser (User user);

    void deleteUsers(Integer id);
}
