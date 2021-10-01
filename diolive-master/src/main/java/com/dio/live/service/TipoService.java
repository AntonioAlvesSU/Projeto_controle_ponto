package com.dio.live.service;

import com.dio.live.model.TipoData;
import com.dio.live.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    TipoRepository tipoRepository;

    @Autowired
    public TipoService(TipoRepository tipoRepository) { this.tipoRepository = tipoRepository;
    }

    public TipoData saveTipo(TipoData tipoData) { return tipoRepository.save(tipoData);

    }

    public List<TipoData> findAll() {
        return   tipoRepository.findAll();
    }

    public Optional<TipoData> getById(Long idTipo) {
        return tipoRepository.findById(idTipo);
    }

    public TipoData updateTipo(TipoData tipoData){ return tipoRepository.save(tipoData);

    }

    public void deleteTipo(Long idTipo) {
        tipoRepository.deleteById(idTipo);
    }
}
