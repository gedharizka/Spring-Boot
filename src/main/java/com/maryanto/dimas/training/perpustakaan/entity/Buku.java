package com.maryanto.dimas.training.perpustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * create table buku
 * (
 * id           varchar(64)  not null primary key,
 * isbn         varchar(60)  not null unique,
 * judul        varchar(100) not null,
 * deskripsi    text,
 * penerbit_id  varchar(64)  not null,
 * pengarang_id varchar(64)  not null
 * ) engine = InnoDb;
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buku")
public class Buku {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "isbn", nullable = false, unique = true, length = 60)
    private String isbn;

    @Column(name = "judul", nullable = false)
    private String judul;

    @Type(type = "text")
    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "penerbit_id", nullable = false)
    private Penerbit penerbit;

    @ManyToOne
    @JoinColumn(name = "pengarang_id", nullable = false)
    private Pengarang pengarang;
}
