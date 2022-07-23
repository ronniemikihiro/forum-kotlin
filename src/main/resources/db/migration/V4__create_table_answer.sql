create table answer(
    id bigint not null auto_increment,
    title varchar(50) not null,
    message varchar(300) not null,
    creation_date datetime not null,
    topic_id bigint not null,
    author_id bigint not null,
    solution tinyint not null,
    primary key(id),
    foreign key(topic_id) references topic(id),
    foreign key(author_id) references user_forum(id)
);