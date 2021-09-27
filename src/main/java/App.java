import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.List;

//import static spark.Spark.post;
//import static spark.Spark.staticFileLocation;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql' ";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
//        conn =  Sql2o.open();
//        post("/news/new","application/json", (req, res) -> {
//            News news = gson.fromJson(req.body(), News.class);
//            newsDao.add(news);
//            res.status(201);
//            res.type("application/json");
//            return gson.toJson(news);
//        });
//        post("/departments/:department_id/users/new", "application/json", (req, res) -> {
//            int department_id = Integer.parseInt(req.params("department_id"));
//            User user = gson.fromJson(req.body(), User.class);
//
//            user.setDepartment_id(department_id);
//            userDao.add(user);
//            res.status(201);
//            return gson.toJson(user);
////        });
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
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
           userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });
        get("/news", "application/json", (req, res) -> {
            return gson.toJson(newsDao.getAll());
        });

//        get("/departments", "application/json", (req, res) -> {
//            System.out.println(departmentDao.getAll());
//
//            if(departmentDao.getAll().size() > 0){
//                return gson.toJson(departmentDao.getAll());
//            }
//
//            else {
//                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
//            }
//
//        });
//        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
//            int department_id = Integer.parseInt(req.params("id"));
//            Department departmentToFind = departmentDao.findById(department_id);
//            if (departmentToFind == null){
////                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("department_id")));
//            }
//            return gson.toJson(departmentToFind);
//        });
//        get("/departments/:id/users", "application/json", (req, res) -> {
//            int department_id = Integer.parseInt(req.params("id"));
//
//            Department departmentToFind = departmentDao.findById(department_id);
//            List<User> allUsers;
//
//            if (departmentToFind == null){
////                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
//            }
//
//            allUsers = userDao.getAllUsersByDepartment(department_id);
//
//            return gson.toJson(allUsers);
//        });
        //filter
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
