package com.edubiss.equipe.confronto.confrontoservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConfrontoNaoEncontradoException extends ResponseStatusException{

    public ConfrontoNaoEncontradoException(Long confronto) {
        super(HttpStatus.NOT_FOUND, "Confronto não encontrado, id: " + confronto);
    }
}