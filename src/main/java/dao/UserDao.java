package dao;

import models.User;

import java.util.List;

public interface UserDao {
    void add (User user);
    List<User>getAll();

    List<User> getAllUsersByDepartment(int department_id);

//    List<User>findById();
//    void update();
//    void deleteById();

    void update(int user_id, String newUser_name, String newUser_department, String newUser_role);

    void deleteById(int user_id);

    void clearAll();
}
