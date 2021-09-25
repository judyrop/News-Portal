package dao;

import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
String sql = "INSERT INTO departments(department_name,department_description,employees_number) VALUES(:department_name,:department_description,:employees_number)";
try (Connection con = sql2o.open()){
    int id = (int) con.createQuery(sql,true)
            .bind(department)
            .executeUpdate()
            .getKey();
    department.setDepartment_id(id);

} catch (Sql2oException ex) {
    System.out.println(ex);
}
    }

    @Override
    public Department findById(int id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT  * FROM departments WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Department.class);
        }
        return null;
    }
    @Override
    public List<Department> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }
    @Override
    public void update(int department_id,String newDepartment_name) {
String sql = "UPDATE departments SET department_name = :department_name WHERE id= :id";
try (Connection con = sql2o.open()){
    con.createQuery(sql)
            .addParameter("department_name", newDepartment_name)
            .executeUpdate();
} catch (Sql2oException ex) {
    System.out.println(ex);
}
    }

    @Override
    public void delete() {
        String sql = "DELETE from departments WHERE department_id=:department_id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("department_id", department_id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
