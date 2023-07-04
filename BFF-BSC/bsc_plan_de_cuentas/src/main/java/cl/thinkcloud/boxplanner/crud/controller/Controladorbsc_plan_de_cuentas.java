
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

import cl.thinkcloud.boxplanner.crud.dto.bsc_plan_de_cuentasDTO;
import cl.thinkcloud.boxplanner.crud.entity.bsc_plan_de_cuentasEntity;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
@RequestMapping("/v1/bsc/bsc_plan_de_cuentas")
public class Controladorbsc_plan_de_cuentas {
	
	public final Logger logger = LoggerFactory.getLogger(Controladorbsc_plan_de_cuentas.class);

	
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
	
	@Operation (summary = "agregarbsc_plan_de_cuentas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public bsc_plan_de_cuentasDTO agregarInventario_item(@Valid @NonNull @RequestBody bsc_plan_de_cuentasDTO bsc_plan_de_cuentas) {
    	logger.info("Controlador-bsc_plan_de_cuentas");
        return servicio.save(bsc_plan_de_cuentas);
    }
	
	 //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllbsc_plan_de_cuentas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<bsc_plan_de_cuentasDTO> getAllInventario_item() {
    	logger.info("Controlador-getAllbsc_plan_de_cuentas");
    	List<bsc_plan_de_cuentasDTO> l = servicio.findAll();
    	return l;
    }
	
  //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "getbsc_plan_de_cuentasById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public bsc_plan_de_cuentasDTO getbsc_plan_de_cuentas(@PathVariable("id") int id) {
    	bsc_plan_de_cuentasDTO pDTO = servicio.findById(id).orElse(null); 
    	return pDTO;
    }
    
    
	
    @Operation (summary = "updatebsc_plan_de_cuentasById")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public bsc_plan_de_cuentasDTO updatebsc_plan_de_cuentasById(@Valid @NonNull @RequestBody bsc_plan_de_cuentasDTO bsc_plan_de_cuentas) {
        Optional<bsc_plan_de_cuentasDTO> Ii = servicio.findById(bsc_plan_de_cuentas.getId());
        if (Ii.isPresent()==true) {
            return servicio.save(bsc_plan_de_cuentas);
        } else return null;
    }
    
    
    @Operation (summary = "updatebsc_plan_de_cuentasBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public bsc_plan_de_cuentasDTO updatebsc_plan_de_cuentasById(@Valid @NonNull @RequestBody bsc_plan_de_cuentasDTO bsc_plan_de_cuentas, @PathVariable("id") int id) {
        Optional<bsc_plan_de_cuentasDTO> Ii = servicio.findById(id);
        if (Ii.isPresent()==true) {
        	bsc_plan_de_cuentas.setId(id);
            return servicio.save(bsc_plan_de_cuentas);
        } else return null;
    }
	//DELETE
    @Operation (summary = "deletebsc_plan_de_cuentasById ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public bsc_plan_de_cuentasDTO deletebsc_plan_de_cuentasById(@Valid @NonNull @RequestBody bsc_plan_de_cuentasDTO bsc_plan_de_cuentas) {
        Optional<bsc_plan_de_cuentasDTO> Ii =  servicio.findById(bsc_plan_de_cuentas.getId());
        if (Ii.isPresent()==true) {
            servicio.delete(bsc_plan_de_cuentas.getId());
            return bsc_plan_de_cuentas;
        } else return null;
    }
	
    @Operation (summary = "deletebsc_plan_de_cuentasBy Id PathVariable")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deletebsc_plan_de_cuentasById(@PathVariable("id") int id) {
        Optional<bsc_plan_de_cuentasDTO> Ii =  servicio.findById(id);
        if (Ii.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
	
	
}