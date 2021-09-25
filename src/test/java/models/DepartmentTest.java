package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
      void  DepartmentInstantiatesCorrectly_true() {
    Department testdepartment = new Department("Software developers","section designed for users creating softwares of the company",20);
        assertEquals(true,testdepartment instanceof Department);
    }

    @Test
    void getDepartment_name() {
        Department testdepartment = new Department("Software developers","section designed for users creating softwares of the company",20);
        assertEquals("Software developers",testdepartment.getDepartment_name());
    }

    @Test
    void setDepartment_name() {
    }

    @Test
    void getDepartment_description() {
        Department testdepartment = new Department("Software developers","section designed for users creating softwares of the company",20);
        assertEquals("section designed for users creating softwares of the company",testdepartment.getDepartment_description());
    }

    @Test
    void setDepartment_description() {
    }

    @Test
    void getEmployees_number() {
        Department testdepartment = new Department("Software developers","section designed for users creating softwares of the company",20);
        assertEquals(20,testdepartment.getEmployees_number());
    }

    @Test
    void setEmployees_number() {
    }
}