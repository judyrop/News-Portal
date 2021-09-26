package dao;

import models.User;

import java.util.List;

public interface UserDao {
    void add (User user);
    List<User>getAll();
    List<User>findById();
    void update();
//    void deleteById();

    void deleteById(int user_id);

    void clearAll();
}
