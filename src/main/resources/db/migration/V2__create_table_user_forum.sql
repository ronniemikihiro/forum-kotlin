create table user_forum(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into user_forum values (1, 'Ronnie', 'ronnie@email.com');