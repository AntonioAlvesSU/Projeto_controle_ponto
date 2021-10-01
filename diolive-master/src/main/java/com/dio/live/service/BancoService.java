package com.dio.live.service;

import com.dio.live.model.BancoHoras;
import com.dio.live.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {
    BancoRepository bancoRepository;

    @Autowired
    public BancoService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public BancoHoras saveBanco(BancoHoras bancoHoras){
        return bancoRepository.save(bancoHoras);

    }

    public List<BancoHoras> findAll() {
        return   bancoRepository.findAll();
    }

    public Optional<BancoHoras> getById(Long idBanco) {
        return bancoRepository.findById(idBanco);
    }

    public BancoHoras updateBanco(BancoHoras bancoHoras){
        return bancoRepository.save(bancoHoras);

    }

    public void deleteBanco(Long idBanco) {
        bancoRepository.deleteById(idBanco);
    }


}

