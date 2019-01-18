package com.maryanto.dimas.training.perpustakaan.repository;

import com.maryanto.dimas.training.perpustakaan.entity.Penerbit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PenerbitRepository extends CrudRepository<Penerbit, String> {

    @Modifying
    @Query("update Penerbit set nama = ?1 where id = ?2")
    int updateNamaPenerbit(String nama, String id);

    List<Penerbit> findByNama(String nama);
}
