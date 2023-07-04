package com.bff.bsc.restclients;


import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.ProyectoActividad_TipoActividadDTO;

@FeignClient(name = "bscproyectoactividadmicro", url = "${rest.endpoints.demoweb.url.bsc_proyecto_actividad_tipoactividad}")
public interface bsc_ProyectoActividad_TipoActividad {
	///v1/bff1/micro1
	
	
	@GetMapping(value = "bsc_proyecto_actividad_tipoactividad/REST", produces = "application/json")
    public List<ProyectoActividad_TipoActividadDTO> findAll();
	
	@GetMapping(value = "bsc_proyecto_actividad_tipoactividad/REST/{id}", produces = "application/json")
    public Optional<ProyectoActividad_TipoActividadDTO> findById(@PathVariable("id") int id);
    
	
	@ResponseBody @PostMapping(value = "bsc_proyecto_actividad_tipoactividad/REST", produces = "application/json")
	public ProyectoActividad_TipoActividadDTO save(ProyectoActividad_TipoActividadDTO pa);
	
	@ResponseBody @DeleteMapping("bsc_proyecto_actividad_tipoactividad/REST/{id}")
    public void delete(@PathVariable("id") int id);
}