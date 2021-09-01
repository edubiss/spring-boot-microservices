package com.edubiss.equipe.confronto.confrontoservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EquipeNaoEncontradaException extends ResponseStatusException{

    public EquipeNaoEncontradaException(String equipe, Long equipeId) {
        super(HttpStatus.BAD_REQUEST, "Equipe " + equipe + "não encontrada, id: " + equipeId);
    }

    public EquipeNaoEncontradaException(String equipe) {
        super(HttpStatus.BAD_REQUEST, "Equipe " + equipe + "não informada");
    }
}