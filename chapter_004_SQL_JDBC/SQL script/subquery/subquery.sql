CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);


INSERT INTO customers VALUES 	(1, 'Павел','Иванов',34,'Россия'),
                             	(2, 'Виктор','Юдин',12,'Казахстан'),
				                (3, 'Михаил','Назаров',23,'Беларусь'),
				                (4, 'Сергей','Растяпин',28,'Латвия'),
                             	(5, 'Василий','Антипов',12,'Эстония');

--1. Список клиентов, возраст которых является минимальным.
Select *
from customers
where age=(select min(age) from customers)

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);



INSERT INTO orders VALUES (1, 34, 1),
                          (2, 12,3),
			              (3, 23,5);

--2. Список пользователей, которые еще не выполнили ни одного заказа.
Select *
from customers
where id NOT IN (select customer_id from orders)