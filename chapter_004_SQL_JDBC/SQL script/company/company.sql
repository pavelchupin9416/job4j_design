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

insert into company(id, name) values (1, '�������'),
(2, '��������'),
(3, '���'),
(4, '������'),
(5, 'microsoft');

insert into person(id, name, company_id) VALUES (1, '������', 1),
(2, '�����', 1),
(3, '�������', 2),
(4, '�����', 2),
(5, '�������', 3),
(6, '��������', 3),
(7, '������', 4),
(8, '�����', 4),
(9, '�����', 5),
(10, '����',5),
(11, '������', 5)
(12, '�������',3);


select p.name as "���������", c.name as "��������" from company as c
  join person as p on p.company_id=c.id WHERE c.id != 5

select c.name, count(*)  from company c
join person p on c.id = p.company_id
group by c.name
having count(*) = (select count(*)
from person p
group by company_id
order by count(*) desc
limit 1);