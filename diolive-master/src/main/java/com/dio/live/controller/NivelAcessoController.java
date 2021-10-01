package com.dio.live.controller;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nivel")
public class NivelAcessoController {
    @Autowired
    NivelService nivelService;

    @PostMapping
    public NivelAcesso createNivel(@RequestBody NivelAcesso nivelAcesso){
        return nivelService.saveNivel(nivelAcesso);
    }

    @GetMapping
    public List<NivelAcesso> getNivelList(){
        return nivelService.findAll();

    }

    @GetMapping("/{idNivel}")
    public ResponseEntity<NivelAcesso> getNivelByID(@PathVariable("idNivel") Long idNivel) throws Exception {
        return  ResponseEntity.ok(nivelService.getById(idNivel).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public NivelAcesso updateNivel(@RequestBody NivelAcesso nivelAcesso){
        return nivelService.updateNivel(nivelAcesso);
    }

    @DeleteMapping("/{idNivel}")
    public ResponseEntity deleteByID(@PathVariable("idNivel") Long idNivel) throws Exception {
        try {
            nivelService.deleteJornada(idNivel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<NivelAcesso>) ResponseEntity.ok();

    }

}
