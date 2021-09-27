package dao;

import models.Department;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
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
    int department_id = (int) con.createQuery(sql,true)
            .bind(department)
            .throwOnMappingFailure(false)
            .executeUpdate()
            .getKey();
    department.setDepartment_id(department_id);

} catch (Sql2oException ex) {
    System.out.println(ex);
}
    }


    @Override
    public Department findById(int department_id) {
        try (Connection con = sql2o.open()){
            return con.createQuery("SELECT  * FROM departments WHERE department_id = :department_id")
                    .addParameter("department_id",department_id)
                    .executeAndFetchFirst(Department.class);
        }
    }
    @Override
    public List<Department> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }
    @Override
    public void update(int department_id, String newDepartment_name,String newDepartment_description,int newEmployees_number) {
String sql = "UPDATE departments SET (department_name,department_description,employees_number )= (:department_name,:department_description,,:employees_number )WHERE department_id= :department_id";
try (Connection con = sql2o.open()){
    con.createQuery(sql)
            .addParameter("department_name", newDepartment_name)
            .addParameter("department_description",newDepartment_description)
            .addParameter("employees_number",newEmployees_number)
            .executeUpdate();
} catch (Sql2oException ex) {
    System.out.println(ex);
}
    }

    @Override
    public void deleteById(int department_id) {
        String sql = "DELETE from departments WHERE department_id=:department_id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("department_id", department_id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
String sql = "DELETE from departments";
try(Connection con = sql2o.open()){
    con.createQuery(sql)
            .executeUpdate();
} catch (Sql2oException ex) {
    System.out.println(ex);
}
    }
    @Override
    public void addDepartmentToNews(Department department, News news){
        String sql = "INSERT INTO departments_news (news_id, department_id) VALUES (:news_id, :department_id)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("department_id", department.getDepartment_id())
                    .addParameter("news_id", news.getNews_id())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<News> getAllNewsByDepartment(int department_id){
        List<News> news = new ArrayList();
        String joinQuery = "SELECT news_id FROM departments_news WHERE department_id = :department_id";

        try (Connection con = sql2o.open()) {
            List<Integer> allNews_ids = con.createQuery(joinQuery)
                    .addParameter("department_id", department_id)
                    .executeAndFetch(Integer.class);
            for (Integer news_id : allNews_ids){
                String newsQuery = "SELECT * FROM news WHERE id = :news_id";
                news.add(
                        con.createQuery(newsQuery)
                                .addParameter("news_id", news_id)
                                .executeAndFetchFirst(News.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return news;
    }
}
