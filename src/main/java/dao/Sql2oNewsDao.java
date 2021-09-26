package dao;

import models.Department;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {
    private final Sql2o sql2o;
    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news(name,type,description) VALUES(:name,:type,:description)";
        try (Connection con = sql2o.open()){
            int news_id = (int) con.createQuery(sql,true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setNews_id(news_id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void update() {

   }

    @Override
    public void deleteById(int news_id) {
        String sql = "DELETE from news WHERE news_id=:news_id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("news_id", news_id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from news";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void addNewsToDepartment(News news, Department department){
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
}
