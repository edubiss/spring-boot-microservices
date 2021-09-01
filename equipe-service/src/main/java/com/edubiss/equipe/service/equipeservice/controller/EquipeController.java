package com.edubiss.equipe.service.equipeservice.controller;

import java.util.List;

import com.edubiss.equipe.service.equipeservice.model.Equipe;
import com.edubiss.equipe.service.equipeservice.respository.EquipeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EquipeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EquipeController.class);
	
	@Autowired
	EquipeRepository equipeRepository;
	
	@PostMapping("/")
	public Equipe add(@RequestBody Equipe equipe) {
		LOGGER.info("Equipe add: {}", equipe);
		return equipeRepository.save(equipe);
	}
	
	@GetMapping("/{id}")
	public Equipe findById(@PathVariable("id") Long id) {
		LOGGER.info("Equipe find: id={}", id);
		return equipeRepository.findById(id).orElseThrow(() -> 
			new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipe com id " + id + " não encontrada."));
	}
	
	@GetMapping("/")
	public List<Equipe> findAll() {
		LOGGER.info("Equipe find");
		return equipeRepository.findAll();
	}
	
}
