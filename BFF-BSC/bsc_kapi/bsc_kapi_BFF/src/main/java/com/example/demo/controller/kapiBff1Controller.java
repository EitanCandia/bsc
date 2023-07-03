package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.kapi_final_DTO;
import com.example.demo.service.kapiServiceBff1;


@RestController
@RequestMapping("/v1/bff1")
public class kapiBff1Controller {
	
	@Autowired
	kapiServiceBff1 serviceBff1;
	

	@GetMapping(value = "/micro1FindAll")
    public List<kapi_final_DTO> micro1FindAll()
    {
		return serviceBff1.micro1FindAll(); 
    }
	
	@GetMapping(value = "/micro1FindById/{id}")
    public Optional<kapi_final_DTO> micro1FindById(@PathVariable("id") int id)
	{
		return serviceBff1.micro1FindById(id);
	}
	
    @PostMapping(value = "/kapisave")
    public kapi_final_DTO kapisave(@RequestBody kapi_final_DTO kapi)
    {
    	return serviceBff1.kapisave(kapi);
    }

    @DeleteMapping(value = "/kapidelete/{id}")
    public void kapidelete(@PathVariable int id)
    {
    	serviceBff1.kapidelete(id);
    }
	
    @PutMapping(value = "/kapiupdate/{id}")
    public kapi_final_DTO kapiupdate(@PathVariable ("id") int id,@RequestBody kapi_final_DTO kapi)
    {
    	return serviceBff1.kapiupdate(id, kapi);
    }
}
