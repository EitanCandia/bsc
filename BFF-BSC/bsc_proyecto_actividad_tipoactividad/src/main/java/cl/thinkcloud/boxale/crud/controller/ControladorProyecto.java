package cl.thinkcloud.boxale.crud.controller;

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

import cl.thinkcloud.boxale.crud.dto.ProyectoDTO;
import cl.thinkcloud.boxale.crud.service.CrudServicebsc_proyecto_actividad;
import cl.thinkcloud.boxale.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller @RequestMapping("bsc_proyecto_actividad_tipoactividad")
public class ControladorProyecto {
	
	public final Logger logger = LoggerFactory.getLogger(CrudServicebsc_proyecto_actividad.class);

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
    @Operation (summary = "agregarProyecto ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public ProyectoDTO agregarProyecto(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
    	logger.info("Controlador-agregarPersona");
        return servicio.save(proyecto);
    }
    
    
    //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllProyectos ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<ProyectoDTO> getAllProyectos() {
    	logger.info("Controlador-getAllProyectos");
        return servicio.findAll();
    }

    

    //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "getProyecto by Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public ProyectoDTO getProyecto(@PathVariable("id") int id) {
        ProyectoDTO pDTO = servicio.findById(id).orElse(null); 
    	return pDTO;
    }
    
    
    //PUT http://localhost:8080/persona/REST
    //JSON:
    //{
    //    "id"     : "6",
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updateProyectoById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public ProyectoDTO updateProyectoById(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
        Optional<ProyectoDTO> p = servicio.findById(proyecto.getId());
        if (p.isPresent()==true) {
            return servicio.save(proyecto);
        } else return null;
    }
    
    
    //PUT http://localhost:8080/persona/REST/6
    //JSON:
    //{
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updateProyectoBy Id PathVariable ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public ProyectoDTO updateProyectoById(@Valid @NonNull @RequestBody ProyectoDTO proyecto, @PathVariable("id") int id) {
        Optional<ProyectoDTO> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	proyecto.setId(id);
            return servicio.save(proyecto);
        } else return null;
    }
    
    
    //DEL http://localhost:8080/persona/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deleteProyecto ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public ProyectoDTO deleteProyectoById(@Valid @NonNull @RequestBody ProyectoDTO proyecto) {
        Optional<ProyectoDTO> p =  servicio.findById(proyecto.getId());
        if (p.isPresent()==true) {
            servicio.delete(proyecto.getId());
            return proyecto;
        } else return null;
    }
    
    
    
    //DEL http://localhost:8080/persona/REST/6
    //{
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deleteProyectoBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteProyectoById(@PathVariable("id") int id) {
        Optional<ProyectoDTO> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    
    
    
   
}
