package com.dio.live.controller;



import com.dio.live.model.CategoriaUsuario;

import com.dio.live.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/Categoria")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public CategoriaUsuario createCategoria(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaService.saveCategoria(categoriaUsuario);
    }
    @GetMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        return ResponseEntity.ok(categoriaService.getById(idCategoriaUsuario).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public CategoriaUsuario updateCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaService.updateCategoria(categoriaUsuario);
    }

    @DeleteMapping("/{idCategoriaUsuario}")
    public ResponseEntity deleteByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        try {
            categoriaService.deleteCategoria(idCategoriaUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();

    }
}
