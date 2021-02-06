USE master
GO

-- ALTER DATABASE spring_security_demo_bcrypt SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
-- DROP DATABASE spring_security_demo_bcrypt;

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'spring_security_demo_bcrypt')
BEGIN
    DROP DATABASE spring_security_demo_bcrypt;  
END

CREATE DATABASE spring_security_demo_bcrypt;
GO
USE spring_security_demo_bcrypt;
GO

DROP TABLE IF EXISTS spring_security_demo_bcrypt.dbo.users;
CREATE TABLE spring_security_demo_bcrypt.dbo.users (
    username varchar(50) NOT NULL PRIMARY KEY,
    password char(68) NOT NULL,
    enabled tinyint NOT NULL,
);


INSERT INTO spring_security_demo_bcrypt.dbo.users 
VALUES 
('john','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('mary','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1),
('susan','{bcrypt}$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K',1);

----------


DROP TABLE IF EXISTS spring_security_demo_bcrypt.dbo.authorities;
CREATE TABLE spring_security_demo_bcrypt.dbo.authorities (
   username varchar(50) NOT NULL,
   authority varchar(50) NOT NULL,
   CONSTRAINT authorities_idx_1 UNIQUE(username, authority),
   CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username)
   REFERENCES users (username)
   ON DELETE CASCADE
   ON UPDATE CASCADE
);

INSERT INTO spring_security_demo_bcrypt.dbo.authorities 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');


------------
USE [spring_security_demo_bcrypt];
GRANT SELECT ON dbo.[authorities] TO springstudent;
GRANT SELECT ON dbo.[users] TO springstudent;

