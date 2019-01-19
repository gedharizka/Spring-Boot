alter table anggota
add column created_by varchar (50);

alter table anggota
add column created_date timestamp default now();
