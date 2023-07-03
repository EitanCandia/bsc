package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.bff.bsc.dto.ProyectoDTO;

@FeignClient(name = "proyectoClient", url = "${rest.endpoints.demoweb.url.bsc_proyecto}")
public interface Bsc_proyecto{

		@GetMapping(value = "/v1/bsc/proyecto/REST", produces = "application/json")
	    public List<ProyectoDTO> findAll();
		
		@GetMapping(value = "/v1/bsc/proyecto/REST/{id}", produces = "application/json")
	    public Optional<ProyectoDTO> findById(@PathVariable("id") int id);
	    
	    @ResponseBody @PostMapping(value = "/v1/bsc/proyecto/REST", produces = "application/json")
	    public ProyectoDTO save(ProyectoDTO si);
	    
	    @ResponseBody @DeleteMapping("/v1/bsc/proyecto/REST/{id}")
	    public void delete(@PathVariable("id") int id);
}