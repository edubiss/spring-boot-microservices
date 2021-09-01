package com.edubiss.equipe.confronto.confrontoservice.client;

import java.util.Optional;

import com.edubiss.equipe.confronto.confrontoservice.model.dto.Equipe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "equipe-service")
public interface EquipeClient {

	@GetMapping("/{id}")
	Optional<Equipe> findById(@PathVariable("id") Long id);
	
}
