create table if not exists person
(
   id integer primary key AUTO_INCREMENT,
   first_name varchar(30),
   last_name varchar(30),
   birthdate date
);

create table if not exists product
(
	id integer primary key AUTO_INCREMENT,
	name varchar(30)
);

create table if not exists product_details
(
  product integer primary key references product(id),
  created_by varchar(30),
  created_on timestamp
);

