CREATE table teachers (
	id serial primary key,
	fio varchar(255),
	experience int NULL
);

CREATE table lessons (
    id serial primary key,
    name varchar(255),
    academic_hours int NULL,
    teacher_id int references teachers(id) NULL
);




select * 
from teachers as t  join lessons  as l  
on t.id  = l.teacher_id;

select t.fio, l.name, l.academic_hours  
from teachers as t  join lessons  as l  
on t.id  = l.teacher_id 
where l.name = 'Английский';

select t.fio as "ФИО", l.name as "Предмет", t.experience as "Срок преподавания"  
from teachers as t  join lessons  as l  
on t.id  = l.teacher_id 
where t.experience >5;