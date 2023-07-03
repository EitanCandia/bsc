package com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.dto.ProyectoPersonaDTO;
import com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.service.ICrudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller @RequestMapping("/v1/bsc/proyectopersona")
public class ControladorProyectoPersona {

    public final Logger logger = LoggerFactory.getLogger(ControladorProyectoPersona.class);

    @Autowired
    private ICrudService servicio;

    @Operation (summary = "agregarProyectoPersona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PostMapping("REST")
    public ProyectoPersonaDTO agregarProyectoPersona(@Valid @NonNull @RequestBody ProyectoPersonaDTO proyectoPersona) {
        logger.info("Controlador-agregarProyectoPersona");
        return servicio.save(proyectoPersona);
    }

    @Operation (summary = "getAllProyectoPersonas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST")
    public List<ProyectoPersonaDTO> getAllProyectoPersonas() {
        logger.info("Controlador-getAllProyectoPersonas");
        return servicio.findAll();
    }

    @Operation (summary = "getProyectoPersonaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}")
    public ProyectoPersonaDTO getProyectoPersona(@PathVariable("id") int id) {
        ProyectoPersonaDTO ppDTO = servicio.findById(id).orElse(null);
        return ppDTO;
    }

    @Operation (summary = "updateProyectoPersonaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping("REST")
    public ProyectoPersonaDTO updateProyectoPersonaById(@Valid @NonNull @RequestBody ProyectoPersonaDTO proyectoPersona) {
        Optional<ProyectoPersonaDTO> pp = servicio.findById(proyectoPersona.getBscProyectoId());
        if (pp.isPresent()) {
            return servicio.save(proyectoPersona);
        } else return null;
    }

    @Operation (summary = "updateProyectoPersonaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping("REST/{id}")
    public ProyectoPersonaDTO updateProyectoPersonaById(@Valid @NonNull @RequestBody ProyectoPersonaDTO proyectoPersona, @PathVariable("id") int id) {
        Optional<ProyectoPersonaDTO> pp = servicio.findById(id);
        if (pp.isPresent()) {
            proyectoPersona.setBscProyectoId(id);
            return servicio.save(proyectoPersona);
        } else return null;
    }

    @Operation (summary = "deleteProyectoPersonaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST")
    public ProyectoPersonaDTO deleteProyectoPersonaById(@Valid @NonNull @RequestBody ProyectoPersonaDTO proyectoPersona) {
        Optional<ProyectoPersonaDTO> pp = servicio.findById(proyectoPersona.getBscProyectoId());
        if (pp.isPresent()) {
            servicio.delete(proyectoPersona.getBscProyectoId());
            return proyectoPersona;
        } else return null;
    }

    @Operation (summary = "deleteProyectoPersonaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}")
    public int deleteProyectoPersonaById(@PathVariable("id") int id) {
        Optional<ProyectoPersonaDTO> pp = servicio.findById(id);
        if (pp.isPresent()) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
}
