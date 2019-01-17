create table transaction
(
  id              varchar(64) not null primary key,
  tanggal_pinjam  timestamp   not null default now(),
  anggota_id      varchar(64) not null,
  kembali         boolean     not null default false,
  tanggal_kembali date                 default null
) engine = InnoDB;

create table transaction_detail
(
  id             varchar(64) not null primary key,
  transaction_id varchar(64) not null,
  buku_id        varchar(64) not null
) engine = InnoDB;
