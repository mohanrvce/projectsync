USE master
GO

-- ALTER DATABASE web_customer_tracker SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
-- DROP DATABASE web_customer_tracker;

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'web_customer_tracker')
BEGIN
    DROP DATABASE web_customer_tracker;  
END
CREATE DATABASE web_customer_tracker;
GO

USE web_customer_tracker;
GO

DROP TABLE IF EXISTS web_customer_tracker.dbo.customer;
CREATE TABLE web_customer_tracker.dbo.customer (
    id int IDENTITY(1,1) PRIMARY KEY,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
	email varchar(45) DEFAULT NULL,
);

INSERT INTO web_customer_tracker.dbo.customer (first_name, last_name, email) VALUES ('David', 'Adams', 'david@luv2code.com');
INSERT INTO web_customer_tracker.dbo.customer (first_name, last_name, email) VALUES ('John', 'Doe', 'john@luv2code.com');
INSERT INTO web_customer_tracker.dbo.customer (first_name, last_name, email) VALUES ('Ajay', 'Rao', 'ajay@luv2code.com');
INSERT INTO web_customer_tracker.dbo.customer (first_name, last_name, email) VALUES ('Mary', 'Public', 'mary@luv2code.com');
INSERT INTO web_customer_tracker.dbo.customer (first_name, last_name, email) VALUES ('Maxwell', 'Dixon', 'max@luv2code.com');

---------
USE [web_customer_tracker];
GRANT SELECT ON dbo.[customer] TO springstudent;