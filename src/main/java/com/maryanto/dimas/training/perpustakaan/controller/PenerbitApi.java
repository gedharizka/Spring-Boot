package com.maryanto.dimas.training.perpustakaan.controller;

import com.maryanto.dimas.training.perpustakaan.entity.Penerbit;
import com.maryanto.dimas.training.perpustakaan.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/penerbit")
public class PenerbitApi {

    @Autowired
    private PenerbitRepository repository;

    @GetMapping("/list")
    public Iterable<Penerbit> findAll() {
        return repository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Penerbit> save(@RequestBody Penerbit penerbit) {
        penerbit = repository.save(penerbit);
        return ResponseEntity.ok(penerbit);
    }

    @GetMapping("/findByNama")
    public List<Penerbit> findByNama(@RequestParam("nama") String nama){
        return repository.findByNama(nama);
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<Penerbit> updateNamaPenerbit(@RequestBody Penerbit penerbit) {
        repository.updateNamaPenerbit(penerbit.getNama(), penerbit.getId());
        return ResponseEntity.ok(penerbit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Penerbit> findById(@PathVariable("id") String id) {
        Optional<Penerbit> penerbitOptional = repository.findById(id);
        if (penerbitOptional.isPresent())
            return ResponseEntity.ok(penerbitOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        Optional<Penerbit> penerbitOptional = repository.findById(id);
        if (penerbitOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.noContent().build();
    }
}
