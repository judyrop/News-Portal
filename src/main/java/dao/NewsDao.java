package dao;

import models.Department;
import models.News;

import java.util.List;

public interface NewsDao {
    void add( News news);
  List<News>getAll();
//    void update();
//    void deleteById();

    void update(int news_id, String newName, String newType, String newDescription);

    void deleteById(int news_id);

    void clearAll();

    void addNewsToDepartment(News news, Department department);
}
