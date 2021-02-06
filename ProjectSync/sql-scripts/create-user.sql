-- https://www.hostinger.in/tutorials/mysql/how-create-mysql-user-and-grant-permissions-command-line
-- https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql
-- https://linuxize.com/post/how-to-create-mysql-user-accounts-and-grant-privileges/

CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';
FLUSH PRIVILEGES;  -- changes will take effect immediately 

-- DROP USER ‘user_name’@‘localhost’;
-- GRANT ALL PRIVILEGES ON dbTest.* To 'user'@'hostname' IDENTIFIED BY 'password';