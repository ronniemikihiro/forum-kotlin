create table user_forum(
    --id bigint not null auto_increment, --H2, MYSQL
    id serial primary key, --POSTGRES
    name varchar(50) not null,
    email varchar(50) not null
    --primary key(id) --H2, MYSQL
);

--H2, MYSQL
--insert into user_forum values (1, 'Ronnie', 'ronnie@email.com');

--POSTGRES
insert into user_forum(name, email) values ('Ronnie', 'ronnie@email.com');
