CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Газпром'),
(2, 'Сбербанк'),
(3, 'ВТБ'),
(4, 'Алроса'),
(5, 'microsoft');

insert into person(id, name, company_id) VALUES (1, 'Виктор', 1),
(2, 'Семен', 1),
(3, 'Татьяна', 2),
(4, 'Мария', 2),
(5, 'Николай', 3),
(6, 'Владимир', 3),
(7, 'Никита', 4),
(8, 'Алина', 4),
(9, 'Павел', 5),
(10, 'Иван',5),
(11, 'Андрей', 5)
(12, 'Дмитрий',3);


select p.name as "Сотрудник", c.name as "Компания" from company as c
  join person as p on p.company_id=c.id WHERE c.id != 5

select c.name, count(*)  from company c
join person p on c.id = p.company_id
group by c.name
having count(*) = (select count(*)
from person p
group by company_id
order by count(*) desc
limit 1);