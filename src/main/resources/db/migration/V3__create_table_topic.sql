create table topic(
    --id bigint not null auto_increment, --H2, MYSQL
    id serial primary key, --POSTGRES
    title varchar(50) not null,
    message varchar(300) not null,
    --creation_date datetime not null, --H2, MYSQL
    creation_date timestamp not null, --POSTGRES
    status varchar(20) not null,
    course_id bigint not null,
    author_id bigint not null,
    --primary key(id) --H2, MYSQL
    foreign key(course_id) references course(id),
    foreign key(author_id) references user_forum(id)
);


--H2, MYSQL
--insert into topic values (1, 'Topic 1', 'Messate topic 1', current_timestamp() + interval '1' second, 'NOT_ANSWERED', 1, 1);
--insert into topic values (2, 'Topic 2', 'Messate topic 2', current_timestamp() + interval '2' second, 'NOT_ANSWERED', 1, 1);
--insert into topic values (3, 'Topic 3', 'Messate topic 3', current_timestamp() + interval '3' second, 'NOT_ANSWERED', 1, 1);
--insert into topic values (4, 'Topic 4', 'Messate topic 4', current_timestamp() + interval '4' second, 'NOT_ANSWERED', 1, 1);
--insert into topic values (5, 'Topic 5', 'Messate topic 5', current_timestamp() + interval '5' second, 'NOT_ANSWERED', 1, 1);
--insert into topic values (6, 'Topic 6', 'Messate topic 6', current_timestamp() + interval '6' second, 'NOT_ANSWERED', 2, 1);
--insert into topic values (7, 'Topic 7', 'Messate topic 7', current_timestamp() + interval '7' second, 'NOT_ANSWERED', 2, 1);

--POSTGRES
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 1', 'Messate topic 1', current_timestamp + interval '1' second, 'NOT_ANSWERED', 1, 1);
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 2', 'Messate topic 2', current_timestamp + interval '2' second, 'NOT_ANSWERED', 1, 1);
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 3', 'Messate topic 3', current_timestamp + interval '3' second, 'NOT_ANSWERED', 1, 1);
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 4', 'Messate topic 4', current_timestamp + interval '4' second, 'NOT_ANSWERED', 1, 1);
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 5', 'Messate topic 5', current_timestamp + interval '5' second, 'NOT_ANSWERED', 1, 1);
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 6', 'Messate topic 6', current_timestamp + interval '6' second, 'NOT_ANSWERED', 2, 1);
insert into topic(title, message, creation_date, status, course_id, author_id) values ('Topic 7', 'Messate topic 7', current_timestamp + interval '7' second, 'NOT_ANSWERED', 2, 1);