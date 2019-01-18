package com.maryanto.dimas.training.perpustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "daftarBuku")
@Entity
@Table(name = "pengarang")
public class Pengarang {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Type(type = "text")
    @Column(name = "alamat")
    private String alamat;
//
//    @OneToMany(mappedBy = "pengarang")
//    private List<Buku> daftarBuku = new ArrayList<>();
}
