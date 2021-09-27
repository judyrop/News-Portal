package dao;

import models.Department;
import models.News;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);
//    Department find();

    Department findById(int id);

    List<Department>getAll();
//    void update();

    void update(int department_id, String newDepartment_name, String newDepartment_description, int newEmployees_number);

    void deleteById(int department_id);
    void clearAll();

    void addDepartmentToNews(Department department, News news);

    List<News> getAllNewsByDepartment(int department_id);
}
