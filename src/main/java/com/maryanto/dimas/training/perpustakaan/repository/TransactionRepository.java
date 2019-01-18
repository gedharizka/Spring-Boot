package com.maryanto.dimas.training.perpustakaan.repository;

import com.maryanto.dimas.training.perpustakaan.entity.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

    @Modifying
    @Query("update Transaction set tanggalKembali = :tanggalKembali, kembali = true where id = :id")
    int updatePengembalianBukuById(
            @Param("id") String id,
            @Param("tanggalKembali") Date tanggalKembali);
}
