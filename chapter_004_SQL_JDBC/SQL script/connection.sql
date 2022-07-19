
many-to-one 

create table faculties(
    id serial primary key,
    name varchar(255)   
);
create table teachers(
    id serial primary key,
    FIO varchar(255),
    faculty_id int references faculties(id)
);

many-to-many

create table teacher(
     id serial primary key,
     FIO varchar(255)
 );

 create table lesson(
     id serial primary key,
     name varchar(255)
 );

 create table teacher_lesson(
     id serial primary key,
     teacher_id int references teacher(id),
     lesson_id int references lesson(id)
 );


one-to-one

create table studentTicket(
    id serial primary key,
    course int
);

create table student(
    id serial primary key,
    FIO varchar(255),
    studentTicket_id int references studentTicket(id) unique
);


