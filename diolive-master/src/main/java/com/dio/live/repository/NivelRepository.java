package com.dio.live.repository;

import com.dio.live.model.NivelAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NivelRepository extends JpaRepository<NivelAcesso, Long> {
}
