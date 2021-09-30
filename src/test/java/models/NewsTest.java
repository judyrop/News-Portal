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
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertEquals(true,testNews instanceof News);
    }
    @Test
    void getName() {
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertEquals("Upcoming Event",testNews.getName());
    }

    @Test
    void setName() {
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertNotEquals("Event",testNews.getName());
    }

    @Test
    void getType() {
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertEquals("General",testNews.getType());
    }

    @Test
    void setType() {
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertNotEquals("All",testNews.getType());
    }
    @Test
    void getDescription() {
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertEquals("The event will be virtual do to the pandemic",testNews.getDescription());
    }
    @Test
    void setDescription() {
        News testNews = new News("Upcoming Event","General","The event will be virtual do to the pandemic");
        assertNotEquals("The event will be blended do to the pandemic",testNews.getDescription());
    }
}