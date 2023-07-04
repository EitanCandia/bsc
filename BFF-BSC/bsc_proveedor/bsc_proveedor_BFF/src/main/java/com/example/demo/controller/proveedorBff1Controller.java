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

import com.example.demo.dto.proveedorDTO;
import com.example.demo.service.proveedorServiceBff1;


@RestController
@RequestMapping("/v1/bff1")
public class proveedorBff1Controller {
	
	@Autowired
	proveedorServiceBff1 serviceBff1;
	

	@GetMapping(value = "/proveedorFindAll")
    public List<proveedorDTO> proveedorFindAll()
    {
		return serviceBff1.proveedorFindAll(); 
    }
	
	@GetMapping(value = "/proveedorFindById/{id}")
    public Optional<proveedorDTO> proveedorFindById(@PathVariable("id") int id)
	{
		return serviceBff1.proveedorFindById(id);
	}

    @PostMapping(value = "/proveedorSave")
    public proveedorDTO proveedorSave(@RequestBody proveedorDTO proveedor) 
    {
    return serviceBff1.proveedorSave(proveedor);}
	
    @DeleteMapping("/proveedorDelete/{id}")
    public void proveedordelete(@PathVariable int id) {
        serviceBff1.proveedordelete(id);
    }

    @PutMapping(value = "/proveedorUpdate/{id}")
    public proveedorDTO proveedorUpdate(@PathVariable("id") int id, @RequestBody proveedorDTO proveedor) {
    return serviceBff1.proveedorUpdate(id, proveedor);
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
