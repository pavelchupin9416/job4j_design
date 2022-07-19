Create table student(
    id serial primary key,
    name varchar(255),
    age int,
    date_birthday date
);

insert into student (name,age, date_birthday)
values('Viktor',22,'05.06.2000'),
('Mihail',21,'11.02.2001'),
('Nikolai',19,'05.06.2003');

update student
set name = 'Pavel'
where age>21;

delete from student;