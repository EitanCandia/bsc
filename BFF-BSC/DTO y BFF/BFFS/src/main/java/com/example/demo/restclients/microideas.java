package com.example.demo.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.ideasDTO;

@FeignClient(name = "Micro1Client", url = "${rest.endpoints.demoweb.url.micro1}")
public interface microideas {
	///v1/bff1/micro1
	
	
	@GetMapping(value = "/v1/org/persona/REST", produces = "application/json")
    public List<ideasDTO> findAll();
	
	@GetMapping(value = "/v1/org/persona/REST/{id}", produces = "application/json")
    public Optional<ideasDTO> findById(@PathVariable("id") int id);
    //public PersonaDTO save(PersonaDTO persona);
    //public void delete(int id);
}
