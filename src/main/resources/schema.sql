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
	name varchar(30),
	details_id integer
);

create table if not exists product_details
(
  id integer primary key AUTO_INCREMENT,
  created_by varchar(30),
  created_on timestamp,
  product_id integer,
  constraint product_fk foreign key(product_id) REFERENCES product(id)
);

