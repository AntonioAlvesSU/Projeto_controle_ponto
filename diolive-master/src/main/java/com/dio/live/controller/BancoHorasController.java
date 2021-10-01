package com.dio.live.controller;


import com.dio.live.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dio.live.model.BancoHoras;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/banco")
public class BancoHorasController {
    @Autowired
    BancoService bancoService;

    @PostMapping
    public BancoHoras createBanco(@RequestBody BancoHoras bancoHoras) {
        return bancoService.saveBanco(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getBancoHorasList() {
        return bancoService.findAll();

    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        return ResponseEntity.ok(bancoService.getById(idBancoHoras).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras) {
        return bancoService.updateBanco(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity deleteByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        try {
            bancoService.deleteBanco(idBancoHoras);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();

    }
}
