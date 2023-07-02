package com.bff.bsc.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bff.bsc.dto.ProyectoPersonaDTO;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ProyectoPersonaClient", url = "${rest.endpoints.demoweb.url.bsc_r_proyecto_persona}")
public interface Bsc_r_Proyecto_Persona {

    @GetMapping(value = "/v1/bsc/proyectopersona/REST", produces = "application/json")
    public List<ProyectoPersonaDTO> findAll();

    @GetMapping(value = "/v1/bsc/proyectopersona/REST/{id}", produces = "application/json")
    public Optional<ProyectoPersonaDTO> findById(@PathVariable("id") int id);

    @PostMapping(value = "/v1/bsc/proyectopersona/REST", consumes = "application/json", produces = "application/json")
    public ProyectoPersonaDTO save(@RequestBody ProyectoPersonaDTO proyectoPersona);

    @PutMapping(value = "/v1/bsc/proyectopersona/REST/{id}", produces = "application/json")
    public ProyectoPersonaDTO update(@PathVariable("id") int id, @RequestBody ProyectoPersonaDTO proyectoPersonaDTO);

    @DeleteMapping(value = "/v1/bsc/proyectopersona/REST/{id}", produces = "application/json")
    public void delete(@PathVariable("id") int id);
    
}

