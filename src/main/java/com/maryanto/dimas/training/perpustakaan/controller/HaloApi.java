package com.maryanto.dimas.training.perpustakaan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaloApi {

    @GetMapping("/halo")
    public String halo() {
        return "{\n" +
                "  \"message\": \"Halo ini dari springboot 2!\"\n" +
                "}";
    }
}
