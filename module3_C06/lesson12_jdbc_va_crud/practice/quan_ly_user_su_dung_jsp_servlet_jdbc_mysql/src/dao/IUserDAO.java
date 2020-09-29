package dao;

import model.User;

import java.util.List;

public interface IUserDAO {
    void insertUser(User user);

    User selectUser(String id);

    List<User> selectAllUsers();

    boolean deleteUser(String id);

    boolean updateUser(User user);

    List<User> searchByCountry(String search);

    List<User> sortByName();
}
