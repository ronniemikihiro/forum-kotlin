create table user_forum_role(
    id bigint not null auto_increment,
    user_forum_id bigint not null,
    role_id bigint not null,
    primary key(id),
    foreign key(user_forum_id) references user_forum(id),
    foreign key(role_id) references role(id)
);

insert into user_forum_role values (1, 1, 1);