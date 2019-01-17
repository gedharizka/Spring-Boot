create table anggota
(
  id        varchar(64)  not null primary key,
  nama      varchar(100) not null,
  nomor_ktp varchar(16)  not null unique,
  alamat    text
) engine = InnoDB;

insert into anggota(id, nama, nomor_ktp, alamat)
values ('001', 'Dimas Maryanto', '620412344567', 'Bandung'),
       ('002', 'Muhammad Yusuf', '620412344343', 'Jakarta'),
       ('003', 'Hari sapto adi', '630402343444', 'Jakarta'),
       ('004', 'Fajar cahyono', '620412343434', 'Jakarta');
