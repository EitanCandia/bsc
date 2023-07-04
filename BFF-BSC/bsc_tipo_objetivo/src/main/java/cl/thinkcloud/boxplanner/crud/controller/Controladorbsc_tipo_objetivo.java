package cl.thinkcloud.boxplanner.crud.controller;

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



import cl.thinkcloud.boxplanner.crud.dto.bsc_tipo_objetivoDTO;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Controller @RequestMapping("/v1/bsc/tipo_objetivo")
public class Controladorbsc_tipo_objetivo {

	public final Logger logger = LoggerFactory.getLogger(Controladorbsc_tipo_objetivo.class);
	
	
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
    @Operation (summary = "agregarbsc_tipo_objetivo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public bsc_tipo_objetivoDTO agregarbsc_tipo_objetivo(@Valid @NonNull @RequestBody bsc_tipo_objetivoDTO bsc_tipo_objetivo) {
    	logger.info("Controlador-agregarbsc_tipo_objetivo");
        return servicio.save(bsc_tipo_objetivo);
    }

    

    //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllbsc_tipo_objetivo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<bsc_tipo_objetivoDTO> getAllbsc_tipo_objetivo() {
    	logger.info("Controlador-getAllbsc_tipo_objetivo");
        return servicio.findAll();
    }

    
    
    //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "getbsc_tipo_objetivo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public bsc_tipo_objetivoDTO getbsc_tipo_objetivo(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    
    //PUT http://localhost:8080/persona/REST
    //JSON:
    //{
    //    "id"     : "6",
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updatebsc_tipo_objetivoById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public bsc_tipo_objetivoDTO updatebsc_tipo_objetivoById(@Valid @NonNull @RequestBody bsc_tipo_objetivoDTO bsc_tipo_objetivo) {
        Optional<bsc_tipo_objetivoDTO> to = servicio.findById(bsc_tipo_objetivo.getId());
        if (to.isPresent()==true) {
            return servicio.save(bsc_tipo_objetivo);
        } else return null;
    }
    
    
    
    //PUT http://localhost:8080/persona/REST/6
    //JSON:
    //{
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updatebsc_tipo_objetivoById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public bsc_tipo_objetivoDTO updatebsc_tipo_objetivoById(@Valid @NonNull @RequestBody bsc_tipo_objetivoDTO bsc_tipo_objetivo, @PathVariable("id") int id) {
        Optional<bsc_tipo_objetivoDTO> to = servicio.findById(id);
        if (to.isPresent()==true) {
        	bsc_tipo_objetivo.setId(id);
            return servicio.save(bsc_tipo_objetivo);
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deleteById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public bsc_tipo_objetivoDTO deletebsc_tipo_objetivoById(@Valid @NonNull @RequestBody bsc_tipo_objetivoDTO bsc_tipo_objetivo) {
        Optional<bsc_tipo_objetivoDTO> to =  servicio.findById(bsc_tipo_objetivo.getId());
        if (to.isPresent()==true) {
            servicio.delete(bsc_tipo_objetivo.getId());
            return bsc_tipo_objetivo;
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST/6
    //{
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deletebsc_tipo_objetivoById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deletebsc_tipo_objetivoById(@PathVariable("id") int id) {
        Optional<bsc_tipo_objetivoDTO> to =  servicio.findById(id);
        if (to.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    

}
