
create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
id serial primary key,
name varchar(255),
type_id int references type(id),
expired_date date,
price DECIMAL(18,2)    
);


INSERT INTO public.product ("name",type_id,expired_date,price) VALUES
	 ('Сыр Мацарелла',1,'2022-07-20',500.00),
	 ('Сыр Адыгейский',1,'2022-07-23',32.00),
	 ('Сыр Маскарпоне',1,'2022-07-24',125.00),
	 ('Сыр Рикотта',1,'2022-07-25',543.00),
	 ('Сыр Тофу',1,'2022-07-21',234.00),
	 ('Сыр Филадельфия',1,'2022-07-25',123.00),
	 ('Сыр Пармезан',1,'2022-07-26',1113.00),
	 ('Сыр Чеддер',1,'2022-07-28',546.00),
	 ('Сыр Российский',1,'2022-07-19',521.00),
	 ('Сыр Гауда',1,'2022-07-15',500.00),
	 ('мороженое фисташковое',4,'2022-07-24',500.00),
	 ('мороженое ванильное',4,'2022-07-26',300.00),
	 ('Молком',2,'2022-07-20',100.00),
	 ('Зеленое село',2,'2022-07-24',105.00),
	 ('Солями',3,'2022-07-24',430.00);

INSERT INTO public."type" ("name") VALUES
	 ('СЫР'),
	 ('МОЛОКО'),
	 ('КОЛБАСЫ'),
	 ('МОРОЖЕНОЕ');


1. Написать запрос получение всех продуктов с типом "СЫР"

select p.name, p.price
from product as p join type as t 
on p.type_id=t.id
where t.name='СЫР' 

2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"

select name
from product
where name like '%мороженое%'


3. Написать запрос, который выводит все продукты, срок годности которых уже истек

select name, expired_date
from product where expired_date <  current_date;

4. Написать запрос, который выводит самый дорогой продукт.

select name, price  
from product
 ORDER BY price desc
 limit 1;

5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество

select t.name,COUNT(p.name) 
from type as t join product as p 
on t.id = p.type_id 
group by t.name;

6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"

select p.name 
from type as t join product as p 
on t.id = p.type_id 
where t.name = 'СЫР' or t.name = 'МОЛОКО';


7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. Под количеством подразумевается количество продуктов определенного типа. Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат, то количество продуктов типа "СЫР" будет 2. 

select t.name from type 
as t join product as p on t.id = p.type_id 
group by t.name
having COUNT(p.name) < 10;

8. Вывести все продукты и их тип.

select p.name as "продукт" ,t.name as "тип продукта" 
from type as t join product as p 
on t.id = p.type_id ;

