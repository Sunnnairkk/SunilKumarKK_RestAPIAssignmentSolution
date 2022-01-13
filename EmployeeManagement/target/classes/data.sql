--employeedb;

--create table users
--(
--user_id int primary key auto_increment,
--password varchar(200),
--username varchar(200)
--);

--admin1 admin123
--user1 user123
insert into users(password, username) values('$2a$12$UX3pazFrdzVomiZfl5T1pul3I8UOydfJ8E4X5DmlIWTE77HV4LxDe','admin1');
insert into users (password,username) values('$2a$12$RyPNA5uvkoy9bw/e/FsSEew7dYTO8mbEPleciz3rsxAwujaBqaWU2','user1');

--create table roles
--(
--role_id int primary key auto_increment,
--name varchar(50)
--);

insert into roles (name) values('ADMIN');
insert into roles (name) values('USER');

--create table users_roles
--(
--user_id int,
--role_id int,
--foreign key(user_id) references users(user_id),
--foreign key(role_id) references roles(role_id)
--);

insert into users_roles (user_id,role_id) values (1,1);
insert into users_roles (user_id,role_id) values (2,2);

--create table employee
--(
--id int primary key auto_increment,
--first_name varchar(50),
--last_name varchar(50),
--email varchar(50)
--);

insert into employee (first_name, last_name, email) values ('sunil', 'kumar', 'sk@gmail.com');
insert into employee (first_name, last_name, email) values ('sunilkumar', 'KK', 'skn@gmail.com');
insert into employee (first_name, last_name, email) values ('great', 'learning', 'gl@greatlearning.com');

