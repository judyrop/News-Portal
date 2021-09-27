import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql' ";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        conn =  Sql2o.open();

        post("/departments/:department_id/users/new", "application/json", (req, res) -> {
            int department_id = Integer.parseInt(req.params("department_id"));
            User user = gson.fromJson(req.body(), User.class);

            user.setDepartment_id(department_id);
            userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            return gson.toJson(news);
        });
        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

    }
}
