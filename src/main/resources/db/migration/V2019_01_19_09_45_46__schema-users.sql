create table users
(
  id         varchar(64)  not null primary key,
  uname      varchar(100) not null unique,
  password   varchar(255) not null,
  is_enabled boolean      not null default false
) engine = InnoDB;

create table roles
(
  id   int         not null primary key auto_increment,
  name varchar(50) not null unique
) engine = InnoDB;

create table user_roles
(
  id      varchar(64) not null primary key,
  user_id varchar(64) not null,
  role_id int         not null
) engine = InnoDb;

alter table user_roles
  add constraint fk_user_roles_user_id foreign key (user_id)
    references users (id) on update cascade on delete cascade;

alter table user_roles
  add constraint fk_user_roles_role_id foreign key (role_id)
    references roles (id) on update cascade on delete cascade;

alter table user_roles
  add constraint uq_user_role_duplicates unique (user_id, role_id);
