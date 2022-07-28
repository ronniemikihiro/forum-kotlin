create table course(
    --id bigint not null auto_increment, --H2, MYSQL
    id serial primary key, --POSTGRES
    name varchar(50) not null,
    category varchar(50) not null
    --primary key(id) ----H2, MYSQL
);

--H2, MYSQL
--insert into course values (1, 'Kotlin', 'PROGRAMAÇÃO');
--insert into course values (2, 'Html', 'FRONT-END');

--POSTGRES
insert into course(name, category) values ('Kotlin', 'PROGRAMAÇÃO');
insert into course(name, category) values ('Html', 'FRONT-END');