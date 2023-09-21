CREATE DATABASE crud;
USE crud;

CREATE TABLE students(
id int auto_increment primary key,
FirstName varchar(20)) not null,
LastName varchar(20) not null,
COURSE varchar(20) not null
);

INSERT INTO students(FirstName, LastName, COURSE) VALUES("James", "Colem", "java");