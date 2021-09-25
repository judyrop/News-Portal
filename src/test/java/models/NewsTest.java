package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void  NewsInstantiatesCorrectly_true() {
        News testNews = new News("EventNews","General");
        assertEquals(true,testNews instanceof News);
    }
    @Test
    void getName() {
        News testNews = new News("EventNews","General");
        assertEquals("EventNews",testNews.getName());
    }

    @Test
    void setName() {

    }

    @Test
    void getType() {
        News testNews = new News("EventNews","General");
        assertEquals("General",testNews.getType());
    }

    @Test
    void setType() {
    }
}