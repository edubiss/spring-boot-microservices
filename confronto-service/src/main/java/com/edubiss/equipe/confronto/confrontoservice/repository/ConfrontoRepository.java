package com.edubiss.equipe.confronto.confrontoservice.repository;

import java.util.Optional;

import com.edubiss.equipe.confronto.confrontoservice.model.Confronto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfrontoRepository extends JpaRepository<Confronto, Long> {

    Optional<Confronto> findById(Long id);
}
