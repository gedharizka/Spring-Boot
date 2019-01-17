create table pengarang
(
  id     varchar(64)  not null primary key,
  nama   varchar(100) not null,
  alamat text
) engine = InnoDB;

insert into pengarang(id, nama, alamat) values
('001', 'Dimas maryanto', 'Bandung'),
('002', 'Rega Rusty', 'Jakarta');
