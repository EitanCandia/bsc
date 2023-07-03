package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ideasDTO;
import com.example.demo.service.ServiceBff1;



@RestController
@RequestMapping("/v1/bff1")
public class BFFideas {
	
	@Autowired
	ServiceBff1 serviceBff1;
	

	@GetMapping(value = "/micro1FindAll")
    public List<ideasDTO> micro1FindAll()
    {
		return serviceBff1.micro1FindAll(); 
    }
	
	@GetMapping(value = "/micro1FindById/{id}")
    public Optional<ideasDTO> micro1FindById(@PathVariable("id") int id)
	{
		return serviceBff1.micro1FindById(id);
	}
	
    //public PersonaDTO micro1Save(PersonaDTO persona);
    //public void micro1Delete(int id);
    
	/*
    //micro2 Mickey Mouse
	@GetMapping(value = "/micro2FindAll")
    public List<PersonaDTO> micro2FindAll()
    {
		return serviceBff1.micro2FindAll();
    }
	
	
	@GetMapping(value = "/micro2FindById")
    public Optional<PersonaDTO> micro2FindById(int id)
	{
		return serviceBff1.micro2FindById(id);
    }
    */
	
    //public PersonaDTO micro2Save(PersonaDTO persona);
    //public void micro2Delete(int id);
	
	
}
