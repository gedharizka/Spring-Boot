package com.maryanto.dimas.training.perpustakaan.controller;

import com.maryanto.dimas.training.perpustakaan.entity.Pengarang;
import com.maryanto.dimas.training.perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengarang")
public class PengarangApi {

    @Autowired
    private PengarangRepository repository;

    @GetMapping("/list")
    public Iterable<Pengarang> findAll() {
        return repository.findAll();
    }
}
