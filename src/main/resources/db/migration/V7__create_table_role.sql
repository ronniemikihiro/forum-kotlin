create table role(
    --id bigint not null auto_increment, --H2, MYSQL
    id serial primary key, --POSTGRES
    name varchar(50) not null
    --primary key(id) --H2, MYSQL
);

--H2, MYSQL
--insert into role values (1, 'read_write');

--POSTGRES
insert into role(name) values ('read_write');