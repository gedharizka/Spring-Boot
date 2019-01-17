create table penerbit
(
  id   varchar(64)  not null primary key,
  nama varchar(255) not null
) engine = InnoDb;

insert into penerbit(id, nama)
values ('001', 'Informatika'),
       ('002', 'Gramedia');
