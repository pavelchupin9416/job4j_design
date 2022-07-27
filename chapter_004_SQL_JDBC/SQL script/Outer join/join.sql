
create table department(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    department_id int references department(id)
);

insert into department(name) values ('department 1'),
('department 2'),
('department 3'),
('department 4');

insert into employees(name,department_id) values ('Иванов',1),
('Петров',2),
('Сидоров',3),
('Васильев', null),
('Иванова',1);


--2. Выполнить запросы с left, rigth, full, cross соединениями

select * 
from department d left join employees e 
on d.id = e.department_id;

select * 
from department d right  join employees e 
on d.id = e.department_id;

select * 
from department d full join employees e 
on d.id = e.department_id;

select * 
from department d cross join employees e;

--3. Используя left join найти департаменты, у которых нет работников
select d.name 
from department d left join employees e 
on d.id = e.department_id
where e.department_id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат (порядок вывода колонок в эти запросах также должен быть идентичный). 

select d.name,e.name 
from department d right  join employees e 
on d.id = e.department_id
where d.name is not null;

select d.name,e.name  
from department d left join employees e 
on d.id = e.department_id
where e.department_id is not null;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары

create table teens (
    id serial primary key,
    name varchar(30),
    gender varchar(2)
);

insert into teens (name, gender) values
('Петр', 'M'), 
('Екатерина', 'W'), 
('Ольга', 'W'),
('Николай', 'M'), 
('Александра', 'W'), 
('Дмитрий', 'M');

select n1.name || ' и ' || n2.name as pair 
from teens as n1 cross join teens as n2 
where n1.gender <> n2.gender and n1.gender = 'M' and n2.gender='W';