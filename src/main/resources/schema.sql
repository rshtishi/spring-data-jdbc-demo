create table if not exists person
(
   id integer primary key AUTO_INCREMENT,
   first_name varchar(30),
   last_name varchar(30),
   birthdate date
);