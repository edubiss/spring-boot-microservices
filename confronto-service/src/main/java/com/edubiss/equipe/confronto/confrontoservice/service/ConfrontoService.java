package com.edubiss.equipe.confronto.confrontoservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.edubiss.equipe.confronto.confrontoservice.Exception.ConfrontoNaoEncontradoException;
import com.edubiss.equipe.confronto.confrontoservice.Exception.EquipeNaoEncontradaException;
import com.edubiss.equipe.confronto.confrontoservice.client.EquipeClient;
import com.edubiss.equipe.confronto.confrontoservice.model.Confronto;
import com.edubiss.equipe.confronto.confrontoservice.model.dto.ConfrontoDTO;
import com.edubiss.equipe.confronto.confrontoservice.model.dto.Equipe;
import com.edubiss.equipe.confronto.confrontoservice.repository.ConfrontoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import feign.FeignException.FeignClientException;

@Service
public class ConfrontoService {

    @Autowired
	ConfrontoRepository confrontoRepository;

    @Autowired
	EquipeClient equipeClient;
	
	public Confronto add(Confronto confronto) {
        validarEquipe(Equipe.EQUIPE_MANDANTE, confronto.getEquipeMandante());
        validarEquipe(Equipe.EQUIPE_VISITANTE, confronto.getEquipeVisitante());

		return confrontoRepository.save(confronto);
	}

    public ConfrontoDTO findById(@PathVariable("id") Long id) {
        if (confrontoRepository.findById(id).isPresent()) {
            Confronto c = confrontoRepository.findById(id).get();
            return transformConfrontoToDto(c);
        }

        throw new ConfrontoNaoEncontradoException(id);
	}

    public List<ConfrontoDTO> findAll() {
		return confrontoRepository.findAll().stream().map(c -> transformConfrontoToDto(c)).collect(Collectors.toList());
	}

    private void validarEquipe(String equipe, Long equipeId) {
        try {
            Optional.ofNullable(equipeId).ifPresentOrElse(eq -> {
                this.equipeClient.findById(eq).orElseThrow(() ->
                    new EquipeNaoEncontradaException(equipe, eq)
                );
            }, () -> {
                throw new EquipeNaoEncontradaException(equipe);
            });
        } catch (FeignClientException e) {
            throw new EquipeNaoEncontradaException(equipe);
        }
    }
    
    private ConfrontoDTO transformConfrontoToDto(Confronto c) {
        Equipe mandante = this.equipeClient.findById(c.getEquipeMandante()).orElse(new Equipe("Equipe nāo encontrada!"));
        Equipe visitante = this.equipeClient.findById(c.getEquipeVisitante()).orElse(new Equipe("Equipe nāo encontrada!"));

        return new ConfrontoDTO(c, mandante, visitante);
    }
}
