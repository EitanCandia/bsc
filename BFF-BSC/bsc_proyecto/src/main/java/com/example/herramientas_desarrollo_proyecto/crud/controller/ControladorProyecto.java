package com.example.herramientas_desarrollo_proyecto.crud.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.herramientas_desarrollo_proyecto.crud.dto.ProyectoDTO;
import com.example.herramientas_desarrollo_proyecto.crud.service.ICrudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.NonNull;

@RestController @RequestMapping("/v1/bsc/proyecto")
public class ControladorProyecto {

    public final Logger logger = LoggerFactory.getLogger(ControladorProyecto.class);

    @Autowired
    private ICrudService servicio;

    @Operation(summary = "agregarProyecto")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))})    
    @ResponseBody @PostMapping("REST")
    public ProyectoDTO agregarProyecto(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
		logger.info("Controlador-agregarProyecto");
        return servicio.save(proyecto);
    }

    @Operation(summary = "getAllProyecto")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))})  
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<ProyectoDTO> getAllProyecto() {
		logger.info("Controlador-getAllProyecto");
        return servicio.findAll();
    }

    @Operation(summary = "getProyecto")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))}) 
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public ProyectoDTO getProyecto(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }
    @Operation(summary = "updateProyectoById")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))})  
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public ProyectoDTO updateProyectoById(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
        Optional<ProyectoDTO> p = servicio.findById(proyecto.getId());
        if (p.isPresent()==true) {
            return servicio.save(proyecto);
        } else return null;
    }
    @Operation(summary = "updateProyectoById")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))})  
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public ProyectoDTO updateProyectoById(@Valid @NonNull @RequestBody ProyectoDTO proyecto, @PathVariable("id") int id) {
        Optional<ProyectoDTO> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	proyecto.setId(id);
            return servicio.save(proyecto);
        } else return null;
    }
    @Operation(summary = "deleteProyecto")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))})  
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public ProyectoDTO deleteProyectoById(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
        Optional<ProyectoDTO> p =  servicio.findById(proyecto.getId());
        if (p.isPresent()==true) {
            servicio.delete(proyecto.getId());
            return proyecto;
        } else return null;
    }

    @Operation(summary = "deleteProyectoByid")
    @ApiResponses(value = 
    {@ApiResponse(responseCode = "200", description = "Success",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json")), 
    @ApiResponse(responseCode = "404", description = "Table not found",content = @Content(mediaType = "application/json"))})  
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteProyectoById(@PathVariable("id") int id) {
        Optional<ProyectoDTO> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    

}
