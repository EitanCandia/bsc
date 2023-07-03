
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

import cl.thinkcloud.boxplanner.crud.dto.Inventario_itemDTO;
import cl.thinkcloud.boxplanner.crud.entity.Inventario_itemEntity;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/bsc/inventario_item")
public class ControladorInventario_item {
	
	public final Logger logger = LoggerFactory.getLogger(ControladorInventario_item.class);

	
	@Autowired
	private ICrudService servicio;
	
	//JSON:
    //{
    //	"orgPersonaIdRegistradoPor" : 32,
    //	"bscPlanDeCuentasId" : 43,
	//	"bscProveedorId" : 3,
	//	"bscInventarioUnidadId" : 70,
	//	"nombre" : "roberto",
	//	"alias" : "rob",
	//	"descripcion":"el es rob y es una persona","
	//	"precioConImpuesto" : 23214,
	//	"url": "https://paginaweb.com",
	//	"observacion" : "esta es una observacion",
	//	"fecha_registro": "2023-02-23"
	//	
    //}
	
	@Operation (summary = "agregarInventario_item ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public Inventario_itemDTO agregarInventario_item(@Valid @NonNull @RequestBody Inventario_itemDTO inventario_item) {
    	logger.info("Controlador-agregarInventario_item");
        return servicio.save(inventario_item);
    }
	
	 //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllInventario_item")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<Inventario_itemDTO> getAllInventario_item() {
    	logger.info("Controlador-getAllInventario_item");
    	List<Inventario_itemDTO> l = servicio.findAll();
    	return l;
    }
	
  //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "getInventario_itemById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public Inventario_itemDTO getInventario_item(@PathVariable("id") int id) {
    	Inventario_itemDTO pDTO = servicio.findById(id).orElse(null); 
    	return pDTO;
    }
    
    
	
    @Operation (summary = "updateInventario_itemById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public Inventario_itemDTO updateInventario_itemById(@Valid @NonNull @RequestBody Inventario_itemDTO inventario_item) {
        Optional<Inventario_itemDTO> Ii = servicio.findById(inventario_item.getId());
        if (Ii.isPresent()==true) {
            return servicio.save(inventario_item);
        } else return null;
    }
    
    
    @Operation (summary = "updateInventario_itemBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public Inventario_itemDTO updateInventario_itemById(@Valid @NonNull @RequestBody Inventario_itemDTO inventario_item, @PathVariable("id") int id) {
        Optional<Inventario_itemDTO> Ii = servicio.findById(id);
        if (Ii.isPresent()==true) {
        	inventario_item.setId(id);
            return servicio.save(inventario_item);
        } else return null;
    }
	//DELETE
    @Operation (summary = "deleteInventario_itemById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public Inventario_itemDTO deleteInventario_itemById(@Valid @NonNull @RequestBody Inventario_itemDTO inventario_item) {
        Optional<Inventario_itemDTO> Ii =  servicio.findById(inventario_item.getId());
        if (Ii.isPresent()==true) {
            servicio.delete(inventario_item.getId());
            return inventario_item;
        } else return null;
    }
	
    @Operation (summary = "deleteInventario_itemBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteInventario_itemById(@PathVariable("id") int id) {
        Optional<Inventario_itemDTO> Ii =  servicio.findById(id);
        if (Ii.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
	
	
}