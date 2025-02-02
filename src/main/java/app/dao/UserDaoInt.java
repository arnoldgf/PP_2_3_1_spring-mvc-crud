package app.dao;

import app.model.User;

import java.util.List;

public interface UserDaoInt {
    List<User> getUsers();
    void saveUser (User user);
    void updateUser (User user);
    User findById(Integer id);
    void deleteUser (Integer id);
}
