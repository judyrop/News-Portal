package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUser_name() {
        User testUser = new User("Keilah","Software developers","back-end developer");
        assertEquals("Keilah",testUser.getUser_name());
    }

    @Test
    void setUser_name() {
    }

    @Test
    void getUser_department() {
        User testUser = new User("Keilah","Software developers","back-end developer");
        assertEquals("Software developers",testUser.getUser_department());
    }

    @Test
    void setUser_department() {
    }

    @Test
    void getUser_role() {
        User testUser = new User("Keilah","Software developers","back-end developer");
        assertEquals("back-end developer",testUser.getUser_role());
    }

    @Test
    void setUser_role() {
    }
}