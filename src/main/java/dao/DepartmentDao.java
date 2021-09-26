package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);
//    Department find();

//    Department findById(int id);

    List<Department>getAll();
//    void update();

//    void update(int department_id, String newDepartment_name);
    void deleteById(int department_id);
    void clearAll();
}
