package models;

public class Department {
    private int department_id;
    private String department_name;
    private String department_description;
    private int employees_number;

    public Department(String department_name, String department_description, int employees_number) {
        this.department_name = department_name;
        this.department_description = department_description;
        this.employees_number = employees_number;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_description() {
        return department_description;
    }

    public void setDepartment_description(String department_description) {
        this.department_description = department_description;
    }

    public int getEmployees_number() {
        return employees_number;
    }

    public void setEmployees_number(int employees_number) {
        this.employees_number = employees_number;
    }
}
