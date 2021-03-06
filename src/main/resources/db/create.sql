SET MODE PostgreSQL;
CREATE TABLE IF NOT EXISTS departments (
        department_id int PRIMARY KEY auto_increment,
        department_name VARCHAR ,
        department_description VARCHAR ,
        employees_number int
);
CREATE TABLE IF NOT EXISTS news (
    news_id int PRIMARY KEY auto_increment,
    name VARCHAR ,
    type VARCHAR,
    description VARCHAR
);
CREATE TABLE IF NOT EXISTS users (
    user_id int PRIMARY KEY auto_increment,
    user_name VARCHAR ,
    user_department VARCHAR ,
    user_role VARCHAR
);
CREATE TABLE IF NOT EXISTS departments_news(
    id int PRIMARY KEY auto_increment,
news_id int,
department_id int
);
