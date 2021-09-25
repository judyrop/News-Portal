package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);
    Department find();
    List<Department>getAll();
    void update();
    void delete();

}
