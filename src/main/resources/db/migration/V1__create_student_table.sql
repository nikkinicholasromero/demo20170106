create table students (
    id varchar(38) not null,
    student_number varchar(50) not null,
    first_name varchar(50) not null,
    middle_name varchar(50) not null,
    last_name varchar(50) not null,
    birth_date date,
    primary key (id),
    unique (student_number)
);