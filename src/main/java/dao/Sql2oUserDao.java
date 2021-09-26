package dao;

import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao{
    private final Sql2o sql2o;
    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(User user) {
        String sql = "INSERT INTO users(name,department,role) VALUES(:name,:department,:role)";
        try (Connection con = sql2o.open()){
            int user_id = (int) con.createQuery(sql,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
           user.setUser_id(user_id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM user")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<User> findById() {
        return null;
    }

    @Override
    public void update(int user_id, String newUser_name, String newUser_department, String newUser_role) {
        String sql = "UPDATE user SET (user_name,user_department,user_role )= (:user_name,:user_department,:user_role )WHERE user_id= :user_id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("user_name", newUser_name)
                    .addParameter("user_department",newUser_department)
                    .addParameter("user_role",newUser_role)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int user_id) {
        String sql = "DELETE from users WHERE user_id=:user_id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("user_id", user_id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from users";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
