create table user_forum_role(
    --id bigint not null auto_increment, --H2, MYSQL
    id serial primary key, --POSTGRES
    user_forum_id bigint not null,
    role_id bigint not null,
    --primary key(id) --H2, MYSQL
    foreign key(user_forum_id) references user_forum(id),
    foreign key(role_id) references role(id)
);

--H2, MYSQL
--insert into user_forum_role values (1, 1, 1);

--POSTGRES
insert into user_forum_role(user_forum_id, role_id) values (1, 1);