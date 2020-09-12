insert into person 
values (1, 'Rando', 'Shtishi','1992-08-02');

insert into product
values (1, 'Tablet');

insert into product_details
values (1, 'Rando', CURRENT_TIMESTAMP());

insert into review
values (1, 1, 'Awesome product.');
insert into review
values (2, 1, 'Great tablet.');

insert into manufacturer
values (1, 'Apple','USA');
insert into manufacturer
values (2,'Samsung', 'South Korea');

insert into product_manufacturer
values (1,1);
insert into product_manufacturer
values (2,1);