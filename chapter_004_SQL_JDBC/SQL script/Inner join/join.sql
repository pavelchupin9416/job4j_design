CREATE table teachers (
	id serial primary key,
	fio varchar(255) NULL,
	lesson_id int references lessons(id),
	experience int
);

CREATE table lessons (
    id serial primary key,
    name varchar(255),
    academic_hours int
);




select * from teachers as t  join lessons  as l  on t.lesson_id  = l.id;
select t.fio, l.name, l.academic_hours  from teachers as t  join lessons  as l  on t.lesson_id  = l.id and l.name = 'Английский';
select t.fio as "ФИО", l.name as "Предмет", t.experience as "Срок преподавания"  from teachers as t  join lessons  as l  on t.lesson_id  = l.id and t.experience >5;