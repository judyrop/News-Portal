package models;

public class User {
    private int user_id;
    private String user_name;
    private String user_department;
    private String user_role;

    public User(String user_name, String user_department, String user_role) {
        this.user_name = user_name;
        this.user_department = user_department;
        this.user_role = user_role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_department() {
        return user_department;
    }

    public void setUser_department(String user_department) {
        this.user_department = user_department;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}
