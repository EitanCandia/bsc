package com.tomas.msr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomas.msr.dto.Proyecto_ActividadDTO;

import com.tomas.msr.service.ICrudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.media.Content;

@Controller @RequestMapping("/v1/bsc/proyecto_actividad")
public class ControladorProyecto_Actividad {
	
	public final Logger logger = LoggerFactory.getLogger(ControladorProyecto_Actividad.class);
	
	@Autowired
	private ICrudService servicio;
	
	//GUARDAR EN LA BASE DE DATOS
	//POST http://localhost:8080/proyecto_actividad/REST
	
	@Operation (summary ="agregaProyectoActividad")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody @PostMapping("REST")
	public Proyecto_ActividadDTO agregarProyectoActividad(@RequestBody Proyecto_ActividadDTO proyectoActividad) {
		logger.info("controlador-agregarProyectoActividad");
		return servicio.save(proyectoActividad);
	}
	
	//OBTENER TODOS LOS DATOS
    //GET http://localhost:8080/proyecto_actividad/REST
	@Operation (summary ="obtieneProyectoActividad")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<Proyecto_ActividadDTO> getAllProyectoActividad() {
		logger.info("controlador-obtenerProyectoActividad");
        return servicio.findAll();
    }
    
    //OBTENER DATOS EN BASE A ID
    //GET http://localhost:8080/proyecto_actividad/REST/2
	@Operation (summary ="obtieneProyectoActividadPorId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}")
    public Proyecto_ActividadDTO getProyecto_Actividad(@PathVariable("id") int id) {
    	return servicio.findById(id).orElse(null);
    }
    
    //PUT  http://localhost:8080/proyecto_actividad/REST
    //UPDATE-PUT
	@Operation (summary ="actualizaProyectoActividad")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody 
    @PutMapping("REST")
    public Proyecto_ActividadDTO updateProyecto_ActividadById(@Valid @NonNull @RequestBody Proyecto_ActividadDTO proyectoActividad) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = servicio.findById(proyectoActividad.getId());
    	if (proyecto_actividad.isPresent()) {
    		return servicio.save(proyectoActividad);
    	} else {
    		return null;
    	}
    }
	@Operation (summary ="actualizaProyectoActividadPorId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}"))
    public Proyecto_ActividadDTO updateProyecto_ActividadById(@Valid @NonNull @RequestBody Proyecto_ActividadDTO proyectoActividad,@PathVariable("id") int id) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = servicio.findById(id);
    	if (proyecto_actividad.isPresent()==true) {
    		proyectoActividad.setId(id);
    		return servicio.save(proyectoActividad);
    	} else return null;
    }
    
    //DEL http://localhost:8080/proyecto_actividad/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
	@Operation (summary ="eliminaProyectoActividad")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //
    public Proyecto_ActividadDTO deleteProyecto_ActividadById(@RequestBody Proyecto_ActividadDTO proyectoActividad) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = servicio.findById(proyectoActividad.getId());
    	if (proyecto_actividad.isPresent()==true) {
    		servicio.delete(proyectoActividad.getId());
    		return proyectoActividad;
    	}else return null;
    }
    
    //DEL http://localhost:8080/proyecto_actividad/REST
	@Operation (summary ="eliminaProyectoActividadPorId")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteProyecto_ActividadById(@PathVariable("id") int id) {
    	Optional<Proyecto_ActividadDTO> proyecto_actividad = servicio.findById(id);
    	if (proyecto_actividad.isPresent()==true) {
    		servicio.delete(id);
    		return 1;
    	}else return 0;
    }

}
