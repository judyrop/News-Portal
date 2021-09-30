package dao;

import models.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oDepartmentDaoTest {

    private Sql2oDepartmentDao DepartmentDao;
    private Connection conn;
    @BeforeEach
    void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql' ";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        DepartmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() {
        conn.close();
    }

    @Test
    void addDepartmentSetsDepartment_Id() throws Exception {
        Department department = new Department("Software developers","Section where developers creates different software of the company",20);
        int originalDepartment_Id = department.getDepartment_id();
        DepartmentDao.add(department);
        assertNotEquals(originalDepartment_Id,department.getDepartment_id());
    }

//    @Test
//    void existingDepartmentsCanBeFoundById() throws Exception {
//        Department department = new Department("Software developers","Section where developers creates different software of the company",20);
//        DepartmentDao.add(department);
//        Department foundDepartment = DepartmentDao.findById(department.getDepartment_id());
//        assertEquals(department,foundDepartment.getDepartment_id());
//    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}