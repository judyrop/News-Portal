package dao;

import models.Department;
import models.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {
    private Sql2oNewsDao NewsDao;
    private Connection conn;
    @BeforeEach
    void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql' ";
        Sql2o sql2o = new Sql2o(connectionString,"","");
       NewsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() throws Exception {
        conn.close();
    }

    @Test
    void addNewsSetsNews_Id() throws Exception{
        News news = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        int originalNews_Id = news.getNews_id();
        NewsDao.add(news);
        assertNotEquals(originalNews_Id,news.getNews_id());
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void clearAll() {
    }
}