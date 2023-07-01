package com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.controller;

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

import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.dto.SituacionDTO;
import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Controller @RequestMapping("/v1/bsc/situacion")
public class ControladorSituacion{
	
	public final Logger logger = LoggerFactory.getLogger(ControladorSituacion.class);
	
	@Autowired
	private ICrudService servicio;
	
	//1
	//json a usar:
	// {
	//        "id_bsc_situacion_departamento_idea_proyecto":20,
	//        "bsc_r_situacion_departamento_id":76,
	//        "bsc_idea_id": 88,
	//        "bsc_proyecto_id": 23,
	//        "cantidad_votos": 41,
	//        "incluir": true,
	//        "fecha_registro": "2023-06-26"
	//    }
	
	@Operation (summary = "agregarSituacion")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody @PostMapping("REST")
	public SituacionDTO agregarSituacion(@Valid @NonNull @RequestBody SituacionDTO situacion) {
		logger.info("Controlador-agregarSituacion");
		return servicio.save(situacion);
	}
	
	@Operation (summary = "getAllSituaciones")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody @GetMapping("REST")
	public List<SituacionDTO> getAllSituaciones(){
		logger.info("Controlador-getAllSituaciones");
		return servicio.findAll();
	}
	
	@Operation (summary ="getSituacion ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody @GetMapping("REST/{id}")
	public SituacionDTO getSituacion(@PathVariable("id")int id) {
		return servicio.findById(id).orElse(null);
		
	}
	
	@Operation (summary ="updateSituacionById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody @PutMapping(("REST"))
	public SituacionDTO updateSituacionById(@Valid @NonNull @RequestBody SituacionDTO situacion) {
		Optional<SituacionDTO> s = servicio.findById(situacion.getBsc_r_situacion_departamento_id());
		if (s.isPresent()==true) {
			return servicio.save(situacion);
		}else return null;
	}
	
	@Operation (summary ="updateSituacionById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	@ResponseBody @PutMapping(("REST/{id}"))
	public SituacionDTO updateSituacionById(@Valid @NonNull @RequestBody SituacionDTO situacion, @PathVariable("id") int id) {
		Optional<SituacionDTO> s = servicio.findById(id);
		if (s.isPresent()==true) {
			situacion.setId_bsc_situacion_departamento_idea_proyecto(id);
			return servicio.save(situacion);
		}else return null;
	}
	@Operation (summary = "deleteSituacionById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST")
	public SituacionDTO deleteSituacionById(@Valid @NonNull @RequestBody SituacionDTO situacion) {
		Optional<SituacionDTO> s = servicio.findById(situacion.getBsc_r_situacion_departamento_id());
		if (s.isPresent()==true) {
			servicio.delete(situacion.getId_bsc_situacion_departamento_idea_proyecto());
			return situacion;
		} else return null;
	}
	
	@Operation (summary = "deletePersonaById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}")
	public int deleteSituacionById(@PathVariable("id") int id) {
		Optional<SituacionDTO> s = servicio.findById(id);
		if (s.isPresent()==true) {
			servicio.delete(id);
			return 1;
		} else return 0;
	}

}
	
	
	

