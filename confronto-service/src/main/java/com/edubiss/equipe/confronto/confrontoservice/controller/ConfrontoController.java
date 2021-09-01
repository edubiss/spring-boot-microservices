package com.edubiss.equipe.confronto.confrontoservice.controller;

import java.util.List;

import com.edubiss.equipe.confronto.confrontoservice.model.Confronto;
import com.edubiss.equipe.confronto.confrontoservice.model.dto.ConfrontoDTO;
import com.edubiss.equipe.confronto.confrontoservice.service.ConfrontoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfrontoController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfrontoController.class);
	
	@Autowired
	ConfrontoService confrontoService;
	
	@PostMapping("/")
	public Confronto add(@RequestBody Confronto confronto) {
		LOGGER.info("Confronto add: {}", confronto);
		return confrontoService.add(confronto);
	}
	
	@GetMapping("/{id}")
	public ConfrontoDTO findById(@PathVariable("id") Long id) {
		LOGGER.info("Confronto find: id={}", id);
		return confrontoService.findById(id);
	}
	
	@GetMapping("/")
	public List<ConfrontoDTO> findAll() {
		LOGGER.info("Confronto find");
		return confrontoService.findAll();
	}

}
