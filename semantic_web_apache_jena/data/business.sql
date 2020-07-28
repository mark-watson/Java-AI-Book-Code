create table customers (id int PRIMARY KEY, name char(30), city char(30), state char(30), country char(30));

create table products (id int PRIMARY KEY, name char(40), price float);

create table orders (id int PRIMARY KEY, product_id int REFERENCES products (id), customer_id int REFERENCES customers (id), number int);

insert into customers values (1, 'IBM', 'Armonk', 'New York', 'USA');
insert into customers values (2, 'Oracle', 'Redwood Shores', 'California', 'USA');
	
insert into products values (1, 'KnowledgeBooks NLP Library', 500.0);
insert into products values (2, 'Spider Library', 20.0);

insert into orders values (1, 1, 1, 1);
insert into orders values (2, 2, 1, 2);
insert into orders values (3, 1, 2, 4);
