package com.maryanto.dimas.training.perpustakaan.controller;

import com.maryanto.dimas.training.perpustakaan.entity.Pengarang;
import com.maryanto.dimas.training.perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pengarang")
public class PengarangApi {

    @Autowired
    private PengarangRepository repository;

    @GetMapping("/list")
    public Iterable<Pengarang> findAll() {
        return repository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Pengarang> save(
            @RequestBody Pengarang pengarang) {
        pengarang = repository.save(pengarang);
        return ResponseEntity.ok(pengarang);
    }

    @GetMapping("/contoh")
    public Pengarang init(
            @RequestParam(name = "nama") String data1,
            @RequestParam(value = "alamat", required = false) String data2){
        return new Pengarang(null, data1, data2);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pengarang> findById(
            @PathVariable("id") String pengarangId) {
        Optional<Pengarang> pengarangOptional = repository.findById(pengarangId);
        if (pengarangOptional.isPresent())
            return ResponseEntity.ok(pengarangOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
