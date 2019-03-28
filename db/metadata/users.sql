create table users
(
  id        serial      not null
    constraint users_pk
    primary key,
  login     varchar(50) not null,
  firstname varchar(50) not null,
  lastname  varchar(50) not null,
  password  varchar(20) not null,
  photolink varchar(1000)
);

create unique index users_login_uindex
    on users (login);