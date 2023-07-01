package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.LugarDTO;
//import com.example.demo.entity.LugarEntity;
import com.example.demo.service.ICrudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;

@Controller
@RequestMapping("/v1/bsc/bsc_lugar")
public class LugarController {

	public final Logger logger = LoggerFactory.getLogger(LugarController.class);
	
	@Autowired
	private ICrudService servicio;
	
@Operation (summary = "agregarLugar ")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @PostMapping("REST") //CREATE-POST
public LugarDTO agregarLugar(@NonNull @RequestBody LugarDTO lugar) {
	logger.info("Controlador-agregarLugar");
	return servicio.save(lugar);
}
	
@Operation (summary = "getAllLugar ")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @GetMapping("REST") //READ-GET
public List<LugarDTO> getAllLugar(){
	logger.info("Controlador-getAllLugar");
	return servicio.findAll();
}

@Operation (summary = "getLugar")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @GetMapping("REST/{id}") //READ-GET/id
public LugarDTO getLugar(@PathVariable("id") int id) {
	return servicio.findById(id).orElse(null);
}

@Operation (summary = "updateLugarById")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @PutMapping(("REST")) //UPDATE-PUT
	public LugarDTO updateLugarById(@NonNull @RequestBody LugarDTO lugar) {
	Optional<LugarDTO> l = servicio.findById(lugar.getId());
	if (l.isPresent()==true) {
		return servicio.save(lugar);
	} else return null;
}

@Operation (summary = "updateLugarById")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
	public LugarDTO updateLugarById(@NonNull @RequestBody LugarDTO lugar, @PathVariable("id") int id) {
	Optional<LugarDTO> l = servicio.findById(id);
	if (l.isPresent()==true) {
		lugar.setId(id);
		return servicio.save(lugar);
	} else return null;
}

@Operation (summary = "deleteLugarById")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @DeleteMapping("REST") //DELETE-DELETE
public LugarDTO deleteLugarById(@NonNull @RequestBody LugarDTO lugar) {
	Optional<LugarDTO> l = servicio.findById(lugar.getId());
	if (l.isPresent()==true) {
		servicio.delete(lugar.getId());
		return lugar;
	} else return null;
}

@Operation (summary = "deleteLugarById")
@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
		@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
@ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
public int deleteLugarById(@PathVariable("id") int id) {
	Optional<LugarDTO> l = servicio.findById(id);
	if (l.isPresent()==true) {
		servicio.delete(id);
		return 1;
	} else return 0;
}

}





