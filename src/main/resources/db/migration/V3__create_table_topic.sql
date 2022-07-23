create table topic(
    id bigint not null auto_increment,
    title varchar(50) not null,
    message varchar(300) not null,
    creation_date datetime not null,
    status varchar(20) not null,
    course_id bigint not null,
    author_id bigint not null,
    primary key(id),
    foreign key(course_id) references course(id),
    foreign key(author_id) references user_forum(id)
);


insert into topic values (1, 'Topic 1', 'Messate topic 1', current_timestamp() + interval '1' second, 'NOT_ANSWERED', 1, 1);
insert into topic values (2, 'Topic 2', 'Messate topic 2', current_timestamp() + interval '2' second, 'NOT_ANSWERED', 1, 1);
insert into topic values (3, 'Topic 3', 'Messate topic 3', current_timestamp() + interval '3' second, 'NOT_ANSWERED', 1, 1);
insert into topic values (4, 'Topic 4', 'Messate topic 4', current_timestamp() + interval '4' second, 'NOT_ANSWERED', 1, 1);
insert into topic values (5, 'Topic 5', 'Messate topic 5', current_timestamp() + interval '5' second, 'NOT_ANSWERED', 1, 1);
insert into topic values (6, 'Topic 6', 'Messate topic 6', current_timestamp() + interval '6' second, 'NOT_ANSWERED', 2, 1);
insert into topic values (7, 'Topic 7', 'Messate topic 7', current_timestamp() + interval '7' second, 'NOT_ANSWERED', 2, 1);