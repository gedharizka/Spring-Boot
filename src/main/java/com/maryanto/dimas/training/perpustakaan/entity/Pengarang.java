package com.maryanto.dimas.training.perpustakaan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "daftarBuku")
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

    @JsonIgnore
    @OneToMany(mappedBy = "pengarang")
    private List<Buku> daftarBuku = new ArrayList<>();
}
