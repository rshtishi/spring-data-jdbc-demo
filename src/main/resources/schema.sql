create table if not exists person
(
   id integer primary key AUTO_INCREMENT,
   first_name varchar(30),
   last_name varchar(30),
   birthdate date
);

create table if not exists product_details
(
  id integer primary key AUTO_INCREMENT,
  created_by varchar(30),
  created_on timestamp
);

create table if not exists product
(
	id integer primary key AUTO_INCREMENT,
	name varchar(30),
	details_id integer,
	constraint details_id_fk foreign key(details_id) REFERENCES product_details(id)
);

