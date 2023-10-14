CREATE TABLE users
(
    id varchar(11) NOT NULL ,
    name varchar(100) NOT NULL,
    employeeEmail varchar(100) DEFAULT NULL,
    password varchar(15) NOT NULL,
    PRIMARY KEY (id)
);