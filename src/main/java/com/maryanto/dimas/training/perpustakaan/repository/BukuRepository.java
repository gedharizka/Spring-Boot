package com.maryanto.dimas.training.perpustakaan.repository;

import com.maryanto.dimas.training.perpustakaan.entity.Buku;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BukuRepository extends CrudRepository<Buku, String> {
}
