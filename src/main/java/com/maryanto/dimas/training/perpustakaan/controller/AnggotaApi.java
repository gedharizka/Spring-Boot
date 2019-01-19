package com.maryanto.dimas.training.perpustakaan.controller;

import com.maryanto.dimas.training.perpustakaan.entity.Anggota;
import com.maryanto.dimas.training.perpustakaan.repository.AnggotaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/anggota")
public class AnggotaApi {

    @Autowired
    private AnggotaRepository repository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public Iterable<Anggota> findAll() {
        log.info("method ini di akses");
        return repository.findAll();
    }

    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Anggota> findById(@PathVariable("id") String id) {
        log.info("method ini di akses");
        Optional<Anggota> anggotaOptional = repository.findById(id);
        if (anggotaOptional.isPresent())
            return ResponseEntity.ok(anggotaOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Anggota> save(Principal principal, @RequestBody Anggota anggota) {
        anggota.setCreatedBy(principal.getName());
        anggota.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        anggota = repository.save(anggota);
        log.info("{}", anggota);
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
