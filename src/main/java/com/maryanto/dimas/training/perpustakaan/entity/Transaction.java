package com.maryanto.dimas.training.perpustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * create table transaction
 * (
 * id              varchar(64) not null primary key,
 * tanggal_pinjam  timestamp   not null default now(),
 * anggota_id      varchar(64) not null,
 * kembali         boolean     not null default false,
 * tanggal_kembali date                 default null
 * ) engine = InnoDB;
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "tanggal_pinjam", nullable = false)
    private Timestamp tanggalPinjam;

    @ManyToOne
    @JoinColumn(name = "anggota_id", nullable = false)
    private Anggota anggota;

    @Column(name = "kembali", nullable = false)
    private boolean kembali;

    @Column(name = "tanggal_kembali")
    private Date tanggalKembali;

    @OneToMany(mappedBy = "transaction")
    public List<TransactionDetail> details = new ArrayList<>();
}
