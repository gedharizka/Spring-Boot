package com.maryanto.dimas.training.perpustakaan.controller;

import com.maryanto.dimas.training.perpustakaan.entity.Anggota;
import com.maryanto.dimas.training.perpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaApi {

    @Autowired
    private AnggotaRepository repository;

    @GetMapping("/list")
    public Iterable<Anggota> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anggota> findById(@PathVariable("id") String id) {
        Optional<Anggota> anggotaOptional = repository.findById(id);
        if (anggotaOptional.isPresent())
            return ResponseEntity.ok(anggotaOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<Anggota> save(@RequestBody Anggota anggota) {
        anggota = repository.save(anggota);
        return ResponseEntity.ok(anggota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        Optional<Anggota> anggotaOptional = repository.findById(id);
        if (anggotaOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
