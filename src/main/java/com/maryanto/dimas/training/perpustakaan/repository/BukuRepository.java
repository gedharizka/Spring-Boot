package com.maryanto.dimas.training.perpustakaan.repository;

import com.maryanto.dimas.training.perpustakaan.entity.Buku;
import org.springframework.data.repository.CrudRepository;

public interface BukuRepository extends CrudRepository<Buku, String> {
}
