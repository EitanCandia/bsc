package com.bsc.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.bsc.rest.dto.Bsc_temaDTO;
import com.bsc.rest.entity.Bsc_temaEntity;
import com.bsc.rest.service.ICrudService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Controller @RequestMapping("/v1/bsc/tema")
public class ControladorBsc_tema {
	
	public final Logger logger = LoggerFactory.getLogger(ControladorBsc_tema.class);
	
	@Autowired
    private ICrudService servicio;
	

    //POST http://localhost:8080/bsc_tema/REST
	@Operation (summary = "agregarTema")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	 @ResponseBody @PostMapping("REST") //CREATE-POST
	    public Bsc_temaDTO agregarTema(@Valid @NonNull @RequestBody Bsc_temaDTO tema ) {
			logger.info("Controlador-agregarPersona");
			return servicio.save(tema);
		
	}
	 
	 @Operation (summary = "getAllTema ")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
				@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	    @ResponseBody @GetMapping("REST") //READ-GET
	 	public List<Bsc_temaDTO> getAllTema(){
	 		logger.info("Controlador-getAllTema");
			return servicio.findAll();
	 		
	 	}
	 	
	 	@Operation (summary = "getTema ")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
				@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
	    public Bsc_temaDTO getTema(@PathVariable("id") int id){
	 		return servicio.findById(id).orElse(null);
	 		
	 	}	 
	 	
	 	//PUT http://localhost:8137/v1/bsc/tema
	    //JSON:
	 	 //{
	    //"id": 2,
	    //"bsc_perspectiva_id": 2,
	    //"nombre": "nico",
	    //"alias": "alias",
	    //"descripcion": "aliasdesc",
	    //"orden": 1,
	    //"fecha_registro": "2023-06-08"
	    //}
	 	
	 	@Operation (summary = "updateTemaById ")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
				@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
	    public Bsc_temaDTO updateTemaById(@Valid @NonNull @RequestBody Bsc_temaDTO tema) {
	        Optional<Bsc_temaDTO> p = servicio.findById(tema.getId());
	        if (p.isPresent()==true) {
	            return servicio.save(tema);
	        } else return null;
	    }
	 	
	    //PUT http://localhost:8137/v1/bsc/tema/2
	    //JSON:
		//{
	    //"id": 2,
	    //"bsc_perspectiva_id": 2,
	    //"nombre": "nico",
	    //"alias": "alias",
	    //"descripcion": "aliasdesc",
	    //"orden": 1,
	    //"fecha_registro": "2023-06-08"
	    //}
	    @Operation (summary = "updateTemaById ")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
				@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
	    public Bsc_temaDTO updateTemaById(@Valid @NonNull @RequestBody Bsc_temaDTO tema, @PathVariable("id") int id) {
	        Optional<Bsc_temaDTO> p = servicio.findById(id);
	        if (p.isPresent()==true) {
	        	tema.setId(id);
	            return servicio.save(tema);
	        } else return null;
	    }
	    
	    // DEL http://localhost:8137/v1/bsc/tema/2
		 //{
	    //"id": 2,
	    //"bsc_perspectiva_id": 2,
	    //"nombre": "nico",
	    //"alias": "alias",
	    //"descripcion": "aliasdesc",
	    //"orden": 1,
	    //"fecha_registro": "2023-06-08"
	    //}
	    @Operation (summary = "deleteTemaById ")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
				@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
	    public Bsc_temaDTO deleteTemaById(@Valid @NonNull @RequestBody Bsc_temaDTO tema) {
	        Optional<Bsc_temaDTO> p =  servicio.findById(tema.getId());
	        if (p.isPresent()==true) {
	            servicio.delete(tema.getId());
	            return tema;
	        } else return null;
	    }
	    
	    //DEL http://localhost:8080/persona/REST/6
	    //{
	    //    "nombre" : "registro a eliminar"
	    //}
	    @Operation (summary = "deleteTemaById ")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
				@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
	    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
	    public int deleteTemaById(@PathVariable("id") int id) {
	        Optional<Bsc_temaDTO> T =  servicio.findById(id);
	        if (T.isPresent()==true) {
	            servicio.delete(id);
	            return 1;
	        } else return 0;
	    }
	    
	    
}
