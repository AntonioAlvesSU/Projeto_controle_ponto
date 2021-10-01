package com.dio.live.service;

import com.dio.live.model.NivelAcesso;
import com.dio.live.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {

    NivelRepository nivelRepository;

    @Autowired
    public NivelService(NivelRepository nivelRepository) {
        this.nivelRepository = nivelRepository;
    }

    public NivelAcesso saveNivel(NivelAcesso nivelAcesso){ return nivelRepository.save(nivelAcesso);

    }

    public List<NivelAcesso> findAll() {
        return   nivelRepository.findAll();
    }

    public Optional<NivelAcesso> getById(Long idNivel) {
        return nivelRepository.findById(idNivel);
    }

    public NivelAcesso updateNivel(NivelAcesso nivelAcesso){ return nivelRepository.save(nivelAcesso);

    }

    public void deleteJornada(Long idNivel) {
        nivelRepository.deleteById(idNivel);
    }
}
