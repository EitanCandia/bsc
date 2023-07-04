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

import com.example.demo.dto.proveedorDTO;

@FeignClient(name = "proveedorMicro", url = "${rest.endpoints.demoweb.url.micro1}")
public interface proveedorMicro1 {
	///v1/bff1/micro1
	
	
	@GetMapping(value = "v1/org/proveedor/REST", produces = "application/json")
    public List<proveedorDTO> findAll();
	
	@GetMapping(value = "v1/org/proveedor/REST/{id}", produces = "application/json")
    public Optional<proveedorDTO> findById(@PathVariable("id") int id);
    //public PersonaDTO save(PersonaDTO persona);
    
    @DeleteMapping(value = "v1/org/proveedor/REST/{id}", produces = "application/json")
    public void proveedordelete(@PathVariable("id") int id);

    
    @PostMapping(value = "v1/org/proveedor/REST", consumes = "application/json", produces = "application/json")
    public proveedorDTO proveedorSave(@RequestBody proveedorDTO proveedor);

    @PutMapping(value = "v1/org/proveedor/REST/{id}", consumes = "application/json", produces = "application/json")
    public proveedorDTO proveedorUpdate(@PathVariable("id") int id, @RequestBody proveedorDTO proveedor);

}
