package com.dio.live.controller;

import com.dio.live.model.TipoData;
import com.dio.live.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/tipo")
public class TipoDataController {

    @Autowired
    TipoService tipoService;

    @PostMapping
    public TipoData createTipo(@RequestBody TipoData tipoData){
        return tipoService.saveTipo(tipoData);
    }

    @GetMapping
    public List<TipoData> getTipoList(){
        return tipoService.findAll();

    }

    @GetMapping("/{idTipo}")
    public ResponseEntity<TipoData> getTipoByID(@PathVariable("idTipo") Long idTipo) throws Exception {
        return  ResponseEntity.ok(tipoService.getById(idTipo).orElseThrow(() -> new NoSuchElementException("Not found!")));

    }

    @PutMapping
    public TipoData updateTipo(@RequestBody TipoData tipoData){
        return tipoService.updateTipo(tipoData);
    }

    @DeleteMapping("/{idTipo}")
    public ResponseEntity deleteByID(@PathVariable("idTipo") Long idTipo) throws Exception {
        try {
            tipoService.deleteTipo(idTipo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<TipoData>) ResponseEntity.ok();

    }
}
