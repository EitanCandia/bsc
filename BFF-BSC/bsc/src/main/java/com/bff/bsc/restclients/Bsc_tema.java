package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.Bsc_temaDTO;

@FeignClient(name = "bsctemaClient", url = "${rest.endpoints.demoweb.url.bsc_tema}")
public interface Bsc_tema {

	
	@GetMapping(value = "/v1/bsc/tema/REST", produces = "application/json")
    public List<Bsc_temaDTO> findAll();
	
	@GetMapping(value = "/v1/bsc/tema/REST/{id}", produces = "application/json")
    public Optional<Bsc_temaDTO> findById(@PathVariable("id") int id);
    
    @ResponseBody @PostMapping(value = "/v1/bsc/tema/REST", produces = "application/json")
    public Bsc_temaDTO save(Bsc_temaDTO tema);
    
    @ResponseBody @DeleteMapping("/v1/bsc/tema/REST/{id}")
    public void delete(@PathVariable("id") int id);
}
