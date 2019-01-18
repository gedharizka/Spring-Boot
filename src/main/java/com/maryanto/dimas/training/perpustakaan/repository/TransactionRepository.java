package com.maryanto.dimas.training.perpustakaan.repository;

import com.maryanto.dimas.training.perpustakaan.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
