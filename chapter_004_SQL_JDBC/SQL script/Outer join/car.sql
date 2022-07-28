
create table bodies  (
    id serial primary key,
    name varchar(30)
);

create table engines (
     id serial primary key,
     name varchar(30)
);

create table transmissions (
      id serial primary key,
      name varchar(30)
);

create table cars (
     id serial primary key,
     name varchar(30),
     model varchar(30),
     body_id int references bodies(id),
     engine_id int references engines(id),
     transmission_id int references transmissions(id)
);

insert into bodies(name) values
       ('Хечбэк'), ('Купе'),
       ('Пикап'),('Седан');

insert into engines(name) values
       ('V4'), ('V6'), ('V8'), ('V10'), ('V12');

insert into transmissions(name) values ('Механическая'), ('Автомат'), ('Робот');

insert into cars(name, model, body_id, engine_id, transmission_id) values
('Chevrolet', 'camaro', 2, 1, 2), 
('Opel', 'astra', 1, 2, 1),
('Volkswagen', 'passat', 1, 2, 1), 
('Ford', 'focus', 3, 1, 1),
('Audi', 'r8', 1, 2, 2), 
('Nissan', 'skyline', 1, 1, 1),
('Bmw', 'x5', 2, 2, 2), 
('Mersedes', 'benz', 1, 2, 1),
('Peugeot', '406', 2, null, 1), 
('Toyota', 'land cruiser', 1, 2, null),
('Lexus', 'lx 570', null, null, null);


--Вывести список всех машин и все привязанные к ним детали. 

select c.name, c.model, b.name, e.name, g.name
from cars as c
left join bodies b on c.body_id = b.id
left join engines e on e.id = c.engine_id
left join transmissions g on g.id = c.transmission_id;

--Вывести кузовы, которые не используются НИ в одной машине

select bodies.name 
from cars right join bodies
on bodies.id = cars.body_id
where cars.model is null;

--Вывести двигатели, которые не используются НИ в одной машине
select engines.name 
from engines left join cars 
on engines.id = cars.engine_id
where cars.name is null;

--Вывести коробки передач
select transmissions.name 
from cars right join transmissions
on transmissions.id = cars.transmission_id
where cars.model is null;