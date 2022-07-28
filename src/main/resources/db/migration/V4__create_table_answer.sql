create table answer(
    --id bigint not null auto_increment, --H2, MYSQL
    id serial primary key, --POSTGRES
    title varchar(50) not null,
    message varchar(300) not null,
    --creation_date datetime not null, --H2, MYSQL
    creation_date timestamp not null, --POSTGRES
    topic_id bigint not null,
    author_id bigint not null,
--    solution tinyint not null, --H2, MYSQL
    solution smallint not null, --POSTGRES
    --primary key(id) --H2, MYSQL
    foreign key(topic_id) references topic(id),
    foreign key(author_id) references user_forum(id)
);