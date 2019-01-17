package com.maryanto.dimas.training.perpustakaan.repository;

import com.maryanto.dimas.training.perpustakaan.entity.Pengarang;
import org.springframework.data.repository.CrudRepository;

public interface PengarangRepository extends CrudRepository<Pengarang, String> {
}
