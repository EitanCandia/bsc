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



import cl.thinkcloud.boxplanner.crud.dto.Bsc_perspectivaDTO;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Controller @RequestMapping("/v1/bsc/perspectiva")
public class Controladorbsc_perspectiva {

	public final Logger logger = LoggerFactory.getLogger(Controladorbsc_perspectiva.class);
	
	
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
    @Operation (summary = "agregarbsc_perspectiva")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public Bsc_perspectivaDTO agregarbsc_perspectiva(@Valid @NonNull @RequestBody Bsc_perspectivaDTO bsc_perspectiva) {
    	logger.info("Controlador-agregarbsc_perspectiva");
        return servicio.save(bsc_perspectiva);
    }

    

    //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllbsc_perspectiva")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<Bsc_perspectivaDTO> getAllbsc_perspectiva() {
    	logger.info("Controlador-getAllbsc_perspectiva");
        return servicio.findAll();
    }

    
    
    //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "getbsc_perspectiva")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public Bsc_perspectivaDTO getbsc_perspectiva(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    
    //PUT http://localhost:8080/persona/REST
    //JSON:
    //{
    //    "id"     : "6",
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updatebsc_perspectiva")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public Bsc_perspectivaDTO updatebsc_perspectivaById(@Valid @NonNull @RequestBody Bsc_perspectivaDTO bsc_perspectiva) {
        Optional<Bsc_perspectivaDTO> to = servicio.findById(bsc_perspectiva.getId());
        if (to.isPresent()==true) {
            return servicio.save(bsc_perspectiva);
        } else return null;
    }
    
    
    
    //PUT http://localhost:8080/persona/REST/6
    //JSON:
    //{
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updatebsc_perspectiva")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public Bsc_perspectivaDTO updatebsc_perspectivaById(@Valid @NonNull @RequestBody Bsc_perspectivaDTO bsc_perspectiva, @PathVariable("id") int id) {
        Optional<Bsc_perspectivaDTO> to = servicio.findById(id);
        if (to.isPresent()==true) {
        	bsc_perspectiva.setId(id);
            return servicio.save(bsc_perspectiva);
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deleteById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public Bsc_perspectivaDTO deletebsc_perspectivaById(@Valid @NonNull @RequestBody Bsc_perspectivaDTO bsc_perspectiva) {
        Optional<Bsc_perspectivaDTO> to =  servicio.findById(bsc_perspectiva.getId());
        if (to.isPresent()==true) {
            servicio.delete(bsc_perspectiva.getId());
            return bsc_perspectiva;
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST/6
    //{
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deletebsc_perspectivaById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deletebsc_perspectivaById(@PathVariable("id") int id) {
        Optional<Bsc_perspectivaDTO> to =  servicio.findById(id);
        if (to.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    

}
