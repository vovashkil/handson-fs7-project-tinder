create table messages
(
  id serial not null
    constraint messages_pk
    primary key,
  from_userid integer not null
    constraint messages_users_id_fk_fromuserid
    references users,
  to_userid integer not null
    constraint messages_users_id_fk_touserid
    references users,
  message varchar(1000) not null,
  sendtime timestamp default now() not null
);