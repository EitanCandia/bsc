package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bff.bsc.dto.ideasDTO;




@FeignClient(name = "Micro1Client", url = "${rest.endpoints.demoweb.url.bsc_ideas}")
public interface bsc_ideas {
	///v1/bff1/micro1
	
	
	@GetMapping(value = "/v1/org/persona/REST", produces = "application/json")
    public List<ideasDTO> findAll();
	
	@GetMapping(value = "/v1/org/persona/REST/{id}", produces = "application/json")
    public Optional<ideasDTO> findById(@PathVariable("id") int id);
 
	 @DeleteMapping(value = "/v1/org/persona/REST/{id}", produces = "application/json")
    public void delete(@PathVariable("id") int id);
    
    @PostMapping(value = "/v1/org/persona/REST/{id}", consumes = "application/json", produces = "application/json")
    public ideasDTO save(ideasDTO ideas);

    @PutMapping(value = "/v1/org/persona/REST/{id}", consumes = "application/json", produces = "application/json")
    public ideasDTO update(@PathVariable("id") int id, @RequestBody bsc_ideas ideas);

     
}
