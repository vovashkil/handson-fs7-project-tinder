create table likedlist
(
  id            serial                  not null
    constraint likedlist_pk
    primary key,
  userid        integer                 not null
    constraint likedlist_users_id_fk_userid
    references users,
  marked_userid integer                 not null
    constraint likedlist_users_id_fk_mrked_userid
    references users,
  islike        boolean                 not null,
  checktime     timestamp default now() not null
);