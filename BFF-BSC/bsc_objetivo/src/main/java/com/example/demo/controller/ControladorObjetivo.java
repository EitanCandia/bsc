package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import com.example.demo.dto.ObjetivoDTO;
import com.example.demo.service.ICrudService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;


@Controller @RequestMapping("/v1/bsc/bsc_objetivo")
public class ControladorObjetivo {

	public final Logger logger = LoggerFactory.getLogger(ControladorObjetivo.class);
	
	
    @Autowired
    private ICrudService servicio;
    
    //CRUD
    //CREATE-READ-UPDATE-DELETE
    
    //METHOD
    //POST
    //GET
    //PUT
    //DELETE

    //POST http://localhost:8080/persona/REST
    //JSON:
    //{
    //    "nombre" : "Juan",
    //    "apellido" : "Perez"
    //}
    
    @Operation (summary = "agregarObjetivo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @PostMapping("REST") //CREATE-POST
    public ObjetivoDTO agregarObjetivo(@Valid @NonNull @RequestBody ObjetivoDTO objetivo) {
    	
    	logger.info("Controlador-agregarObjetivo");
    	
        return servicio.save(objetivo);
    }

    

    //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllObjetivo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @GetMapping("REST") //READ-GET
    public List<ObjetivoDTO> getAllObjetivos() {
    	
    	logger.info("Controlador-getAllObjetivo");
    	
        return servicio.findAll();
    }

    
    
    //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "getObjetivo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public ObjetivoDTO getObjetivo(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    
    //PUT http://localhost:8080/persona/REST
    //JSON:
    //{
    //    "id"     : "6",
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updateObjetivoById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public ObjetivoDTO updateObjetivoById(@Valid @NonNull @RequestBody ObjetivoDTO objetivo) {
        Optional<ObjetivoDTO> p = servicio.findById(objetivo.getId());
        if (p.isPresent()==true) {
            return servicio.save(objetivo);
        } else return null;
    }
    
    
    
    //PUT http://localhost:8080/persona/REST/6
    //JSON:
    //{
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}    
    @Operation (summary = "updateObjetivoById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public ObjetivoDTO updateObjetivoById(@Valid @NonNull @RequestBody ObjetivoDTO objetivo, @PathVariable("id") int id) {
        Optional<ObjetivoDTO> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	objetivo.setId(id);
            return servicio.save(objetivo);
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
    
    @Operation (summary = "deleteObjetivoById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public ObjetivoDTO deleteObjetivoById(@Valid @NonNull @RequestBody ObjetivoDTO objetivo) {
        Optional<ObjetivoDTO> p =  servicio.findById(objetivo.getId());
        if (p.isPresent()==true) {
            servicio.delete(objetivo.getId());
            return objetivo;
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST/6
    //{
    //    "nombre" : "registro a eliminar"
    //}    
    @Operation (summary = "deleteObjetivoById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestac OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No Encontrado", content = @Content(mediaType = "application/json")) })

    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteObjetivoById(@PathVariable("id") int id) {
        Optional<ObjetivoDTO> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    
}
