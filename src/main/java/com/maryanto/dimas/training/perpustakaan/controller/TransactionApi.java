package com.maryanto.dimas.training.perpustakaan.controller;

import com.maryanto.dimas.training.perpustakaan.entity.Transaction;
import com.maryanto.dimas.training.perpustakaan.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaction")
public class TransactionApi {

    @Autowired
    private TransactionService service;

    @GetMapping("/list")
    public Iterable<Transaction> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable("id") String id) {
        Optional<Transaction> transactionOptional = service.findById(id);
        if (transactionOptional.isPresent())
            return ResponseEntity.ok(transactionOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/peminjaman")
    public ResponseEntity<Transaction> peminjamanBuku(
            @RequestBody Transaction transaction) {
        transaction = service.penjamBuku(transaction);
        return ResponseEntity.ok(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> pengembalianBukuById(@PathVariable("id") String id) {
        Optional<Transaction> transactionOptional = service.findById(id);
        if (!transactionOptional.isPresent())
            return ResponseEntity.noContent().build();
        else {
            service.pengembalian(transactionOptional.get());
            return ResponseEntity.ok().build();
        }
    }
}
