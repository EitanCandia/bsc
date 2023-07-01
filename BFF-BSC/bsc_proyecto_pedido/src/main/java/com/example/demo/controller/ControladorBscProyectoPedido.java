package com.example.demo.controller;


import com.example.demo.crud.dto.DTOBscProyectoPedido;
//import com.example.demo.entity.EntityBscProyectoPedido;
import com.example.demo.service.ICrudService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.media.Content;
@Controller @RequestMapping("/v1/bsc/proyecto_pedido/")


public class ControladorBscProyectoPedido {

	final Logger logger = LoggerFactory.getLogger(ControladorBscProyectoPedido.class);
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
    @Operation (summary = "agregarProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    
    
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public DTOBscProyectoPedido agregarEbpp( @NonNull @RequestBody DTOBscProyectoPedido ebpp) {
        
    	return servicio.save(ebpp);
    }
    

    //GET http://localhost:8080/persona/REST
    @Operation (summary = "getAllProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<DTOBscProyectoPedido> getAllEbpp() {
        return servicio.findAll();
    }

    
    
    //GET http://localhost:8080/persona/REST/6
    @Operation (summary = "finByIdProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public DTOBscProyectoPedido getEbpp(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    
    //PUT http://localhost:8080/persona/REST
    //JSON:
    //{
    //    "id"     : "6",
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @Operation (summary = "updateProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public DTOBscProyectoPedido updateEbppById( @NonNull @RequestBody DTOBscProyectoPedido ebpp) {
        Optional<DTOBscProyectoPedido> p = servicio.findById(ebpp.getId());
        if (p.isPresent()==true) {
            return servicio.save(ebpp);
        } else return null;
    }
    
    
    
    //PUT http://localhost:8080/persona/REST/6
    //JSON:
    //{
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}    
    @Operation (summary = "updateFindByIdProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public DTOBscProyectoPedido updateEbppById( @NonNull @RequestBody DTOBscProyectoPedido ebpp, @PathVariable("id") int id) {
        Optional<DTOBscProyectoPedido> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	ebpp.setId(id);
            return servicio.save(ebpp);
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
    @Operation (summary = "deleteProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public DTOBscProyectoPedido deleteEbppById( @NonNull @RequestBody DTOBscProyectoPedido ebpp) {
        Optional<DTOBscProyectoPedido> p =  servicio.findById(ebpp.getId());
        if (p.isPresent()==true) {
            servicio.delete(ebpp.getId());
            return ebpp;
        } else return null;
    }
    
    //DEL http://localhost:8080/persona/REST/6
    //{
    //    "nombre" : "registro a eliminar"
    //}    
    @Operation (summary = "deleteByIdProyectoPedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta OK", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "No encontrado", content = @Content(mediaType = "application/json")) })
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deleteEbppById(@PathVariable("id") int id) {
        Optional<DTOBscProyectoPedido> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    
    
    
    
    //-WEB-FORM-src/main/resources-------------------------------------------------------------------------------------------------------------
    //http://localhost:8080/persona/listar
    @GetMapping("listar")
    public String listar(Model model) {
        List<DTOBscProyectoPedido> bpp=servicio.findAll();
        model.addAttribute("bsc_proyecto_pedido", bpp);
        return "bpp/index";
    }

    //http://localhost:8080/persona/nuevo
    @GetMapping("nuevo")
    public String agregar(Model model) {
        model.addAttribute("persona", new DTOBscProyectoPedido());
        return "bsc_proyrcto_pedido/form";
    }

    //http://localhost:8080/persona/editar/id
    @GetMapping("editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("bsc_proyecto_pedido", getEbpp(0));
        return "bsc_proyecto_pedido/form";
    }

    //http://localhost:8080/persona/grabar
    @PostMapping("grabar")
    public String save( DTOBscProyectoPedido p, Model model) {
        servicio.save(p);
        return "redirect:/bsc_proyecto_pedido/listar";
    }

    //http://localhost:8080/persona/eliminar/id
    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        servicio.delete(id);
        return "redirect:/bsc_proyecto_pedido/listar";
    }
}

