package com.example.demo.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.kapi_final_DTO;

@FeignClient(name = "kapiClient", url = "${rest.endpoints.demoweb.url.kapi}")
public interface kapiMicro1 {
	///v1/bff1/micro1
	
	
	@GetMapping(value = "/v1/org/kapi/REST", produces = "application/json")
    public List<kapi_final_DTO> findAll();
	
	@GetMapping(value = "/v1/org/kapi/REST/{id}", produces = "application/json")
    public Optional<kapi_final_DTO> findById(@PathVariable("id") int id);
    
    @DeleteMapping(value = "/v1/org/kapi/REST/{id}", produces = "application/json")
    public void kapidelete(@PathVariable("id") int id);

    @PostMapping(value = "/v1/org/kapi/REST", consumes = "application/json", produces = "application/json")
    public kapi_final_DTO kapisave(@RequestBody kapi_final_DTO kapi);

    @PutMapping(value = "/v1/org/kapi/REST/{id}", consumes = "application/json", produces = "application/json")
    public kapi_final_DTO kapiupdate(@PathVariable("id") int id, @RequestBody kapi_final_DTO kapi);
}
