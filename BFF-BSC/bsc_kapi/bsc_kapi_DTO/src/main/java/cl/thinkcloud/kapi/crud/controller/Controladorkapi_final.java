package cl.thinkcloud.kapi.crud.controller;

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

import cl.thinkcloud.kapi.crud.dto.kapi_final_DTO;
import cl.thinkcloud.kapi.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/org/kapi")
public class Controladorkapi_final {

    public final Logger logger = LoggerFactory.getLogger(Controladorkapi_final.class);

    @Autowired
    private ICrudService servicio;

    @Operation(summary = "agregarkapi ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @PostMapping("REST") // CREATE-POST
    public kapi_final_DTO agregarkapi(@Valid @NonNull @RequestBody kapi_final_DTO kapi) {
        logger.info("Controlador-agregarkapi");
        return servicio.save(kapi);
    }

    // GET http://localhost:8080/kapi/REST
    @Operation(summary = "getAllkapis ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @GetMapping("REST") // READ-GET
    public List<kapi_final_DTO> getAllkapis() {
        logger.info("Controlador-getAllkapis");
        return servicio.findAll();
    }

    // GET http://localhost:8080/kapi/REST/6
    @Operation(summary = "getkapi by Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @GetMapping("REST/{id}") // READ-GET/id
    public kapi_final_DTO getkapi(@PathVariable("id") int id) {
        kapi_final_DTO pDTO = servicio.findById(id).orElse(null);
        return pDTO;
    }

    // PUT http://localhost:8080/kapi/REST
    // JSON:
    // {
    // "id" : "6",
    // "nombre" : "nuevo nombre",
    // "apellido" : "nuevo apellido"
    // }
    @Operation(summary = "updatekapiById ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @PutMapping(("REST")) // UPDATE-PUT
    public kapi_final_DTO updatekapiById(@Valid @NonNull @RequestBody kapi_final_DTO kapi) {
        Optional<kapi_final_DTO> p = servicio.findById(kapi.getId());
        if (p.isPresent() == true) {
            return servicio.save(kapi);
        } else
            return null;
    }

    // PUT http://localhost:8080/kapi/REST/6
    // JSON:
    // {
    // "nombre" : "nuevo nombre",
    // "apellido" : "nuevo apellido"
    // }
    @Operation(summary = "updatekapiBy Id PathVariable ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @PutMapping(("REST/{id}")) // UPDATE-PUT
    public kapi_final_DTO updatekapiById(@Valid @NonNull @RequestBody kapi_final_DTO kapi,
            @PathVariable("id") int id) {
        Optional<kapi_final_DTO> p = servicio.findById(id);
        if (p.isPresent() == true) {
            kapi.setId(id);
            return servicio.save(kapi);
        } else
            return null;
    }

    // DEL http://localhost:8080/kapi/REST
    // {
    // "id" : "7",
    // "nombre" : "registro a eliminar"
    // }
    @Operation(summary = "deletekapi ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @DeleteMapping("REST") // DELETE-DELETE
    public kapi_final_DTO deletekapiById(@Valid @NonNull @RequestBody kapi_final_DTO kapi) {
        Optional<kapi_final_DTO> p = servicio.findById(kapi.getId());
        if (p.isPresent() == true) {
            servicio.delete(kapi.getId());
            return kapi;
        } else
            return null;
    }

    // DEL http://localhost:8080/kapi/REST/6
    // {
    // "nombre" : "registro a eliminar"
    // }
    @Operation(summary = "deletekapiBy Id PathVariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody
    @DeleteMapping("REST/{id}") // DELETE-DELETE
    public int deletekapiById(@PathVariable("id") int id) {
        Optional<kapi_final_DTO> p = servicio.findById(id);
        if (p.isPresent() == true) {
            servicio.delete(id);
            return 1;
        } else
            return 0;
    }

}
