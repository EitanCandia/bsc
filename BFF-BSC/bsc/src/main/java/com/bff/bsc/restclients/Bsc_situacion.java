package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.bff.bsc.dto.SituacionDTO;

@FeignClient(name = "situacionClient", url = "${rest.endpoints.demoweb.url.bsc_situacion}")
public interface Bsc_situacion {

		@GetMapping(value = "/v1/bsc/situacion/REST", produces = "application/json")
	    public List<SituacionDTO> findAll();
		
		@GetMapping(value = "/v1/bsc/situacion/REST/{id}", produces = "application/json")
	    public Optional<SituacionDTO> findById(@PathVariable("id") int id);
	    
	    @ResponseBody @PostMapping(value = "/v1/bsc/situacion/REST", produces = "application/json")
	    public SituacionDTO save(SituacionDTO si);
	    
	    @ResponseBody @DeleteMapping("/v1/bsc/situacion/REST/{id}")
	    public void delete(@PathVariable("id") int id);
}