package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.Proyecto_ActividadDTO;

@FeignClient(name = "proyectoactividadClient", url = "${rest.endpoints.demoweb.url.bsc_proyecto_actividad}")
public interface Bsc_proyecto_actividad {

	@GetMapping(value = "/v1/bsc/proyecto_actividad/REST", produces = "application/json")
    public List<Proyecto_ActividadDTO> findAll();
	
	@GetMapping(value = "/v1/bsc/proyecto_actividad/REST/{id}", produces = "application/json")
    public Optional<Proyecto_ActividadDTO> findById(@PathVariable("id") int id);
    
    @ResponseBody @PostMapping(value = "/v1/bsc/proyecto_actividad/REST", produces = "application/json")
    public Proyecto_ActividadDTO save(Proyecto_ActividadDTO pa);
    
    @ResponseBody @DeleteMapping("/v1/bsc/proyecto_actividad/REST/{id}")
    public void delete(@PathVariable("id") int id);
}
