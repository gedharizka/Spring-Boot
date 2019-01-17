create table buku
(
  id           varchar(64)  not null primary key,
  isbn         varchar(60)  not null unique,
  judul        varchar(100) not null,
  deskripsi    text,
  penerbit_id  varchar(64)  not null,
  pengarang_id varchar(64)  not null
) engine = InnoDb;

alter table buku
  add constraint fk_buku_penerbit foreign key (penerbit_id)
    references penerbit (id) on update cascade on delete restrict;

alter table buku
  add constraint fk_buku_pengarang foreign key (pengarang_id)
    references pengarang (id) on update cascade on delete restrict;
