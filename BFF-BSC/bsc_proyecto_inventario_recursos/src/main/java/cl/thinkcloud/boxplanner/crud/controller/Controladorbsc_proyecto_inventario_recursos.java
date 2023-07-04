package cl.thinkcloud.boxplanner.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.thinkcloud.boxplanner.crud.entity.bsc_proyecto_inventario_recursos_Entity;
import cl.thinkcloud.boxplanner.crud.service.ICrudService;

@Controller @RequestMapping("bsc_proyecto_inventario_recursos")
public class Controladorbsc_proyecto_inventario_recursos {

    @Autowired
    private ICrudService servicio;
    
    //CRUD
    //CREATE-READ-UPDATE-DELETE
    
    //METHOD
    //POST
    //GET
    //PUT
    //DELETE

    //POST http://localhost:8080/bsc_proyecto_inventario_recursos/REST
    //JSON:
    //{
    //    "nombre" : "Juan",
    //    "apellido" : "Perez"
    //}
    @ResponseBody @PostMapping("REST") //CREATE-POST
    public bsc_proyecto_inventario_recursos_Entity agregarbsc_proyecto_inventario_recursos(@Valid @NonNull @RequestBody bsc_proyecto_inventario_recursos_Entity bsc_proyecto_inventario_recursos) {
        return servicio.save(bsc_proyecto_inventario_recursos);
    }

    

    //GET http://localhost:8080/bsc_proyecto_inventario_recursos/REST
    @ResponseBody @GetMapping("REST") //READ-GET
    public List<bsc_proyecto_inventario_recursos_Entity> getAllbsc_proyecto_inventario_recursoss() {
        return servicio.findAll();
    }

    
    
    //GET http://localhost:8080/bsc_proyecto_inventario_recursos/REST/6
    @ResponseBody @GetMapping("REST/{id}") //READ-GET/id
    public bsc_proyecto_inventario_recursos_Entity getbsc_proyecto_inventario_recursos(@PathVariable("id") int id) {
        return servicio.findById(id).orElse(null);
    }

    
    //PUT http://localhost:8080/bsc_proyecto_inventario_recursos/REST
    //JSON:
    //{
    //    "id"     : "6",
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}
    @ResponseBody @PutMapping(("REST")) //UPDATE-PUT
    public bsc_proyecto_inventario_recursos_Entity updatebsc_proyecto_inventario_recursosById(@Valid @NonNull @RequestBody bsc_proyecto_inventario_recursos_Entity bsc_proyecto_inventario_recursos) {
        Optional<bsc_proyecto_inventario_recursos_Entity> p = servicio.findById(bsc_proyecto_inventario_recursos.getId());
        if (p.isPresent()==true) {
            return servicio.save(bsc_proyecto_inventario_recursos);
        } else return null;
    }
    
    
    
    //PUT http://localhost:8080/bsc_proyecto_inventario_recursos/REST/6
    //JSON:
    //{
    //    "nombre" : "nuevo nombre",
    //    "apellido" : "nuevo apellido"
    //}    
    @ResponseBody @PutMapping(("REST/{id}")) //UPDATE-PUT
    public bsc_proyecto_inventario_recursos_Entity updatebsc_proyecto_inventario_recursosById(@Valid @NonNull @RequestBody bsc_proyecto_inventario_recursos_Entity bsc_proyecto_inventario_recursos, @PathVariable("id") int id) {
        Optional<bsc_proyecto_inventario_recursos_Entity> p = servicio.findById(id);
        if (p.isPresent()==true) {
        	bsc_proyecto_inventario_recursos.setId(id);
            return servicio.save(bsc_proyecto_inventario_recursos);
        } else return null;
    }
    
    //DEL http://localhost:8080/bsc_proyecto_inventario_recursos/REST
    //{
    //    "id"     : "7",
    //    "nombre" : "registro a eliminar"
    //}
    @ResponseBody @DeleteMapping("REST") //DELETE-DELETE
    public bsc_proyecto_inventario_recursos_Entity deletebsc_proyecto_inventario_recursosById(@Valid @NonNull @RequestBody bsc_proyecto_inventario_recursos_Entity bsc_proyecto_inventario_recursos) {
        Optional<bsc_proyecto_inventario_recursos_Entity> p =  servicio.findById(bsc_proyecto_inventario_recursos.getId());
        if (p.isPresent()==true) {
            servicio.delete(bsc_proyecto_inventario_recursos.getId());
            return bsc_proyecto_inventario_recursos;
        } else return null;
    }
    
    //DEL http://localhost:8080/bsc_proyecto_inventario_recursos/REST/6
    //{
    //    "nombre" : "registro a eliminar"
    //}    
    @ResponseBody @DeleteMapping("REST/{id}") //DELETE-DELETE
    public int deletebsc_proyecto_inventario_recursosById(@PathVariable("id") int id) {
        Optional<bsc_proyecto_inventario_recursos_Entity> p =  servicio.findById(id);
        if (p.isPresent()==true) {
            servicio.delete(id);
            return 1;
        } else return 0;
    }
    
    
    
    
    
    
    
    
    
    
    //-WEB-FORM-src/main/resources-------------------------------------------------------------------------------------------------------------
    //http://localhost:8080/bsc_proyecto_inventario_recursos/listar
    @GetMapping("listar")
    public String listar(Model model) {
        List<bsc_proyecto_inventario_recursos_Entity> bsc_proyecto_inventario_recursoss=servicio.findAll();
        model.addAttribute("bsc_proyecto_inventario_recursoss", bsc_proyecto_inventario_recursoss);
        return "bsc_proyecto_inventario_recursos/index";
    }

    //http://localhost:8080/bsc_proyecto_inventario_recursos/nuevo
    @GetMapping("nuevo")
    public String agregar(Model model) {
        model.addAttribute("bsc_proyecto_inventario_recursos", new bsc_proyecto_inventario_recursos_Entity());
        return "bsc_proyecto_inventario_recursos/form";
    }

    //http://localhost:8080/bsc_proyecto_inventario_recursos/editar/id
    @GetMapping("editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<bsc_proyecto_inventario_recursos_Entity> bsc_proyecto_inventario_recursos=servicio.findById(id);
        model.addAttribute("bsc_proyecto_inventario_recursos", bsc_proyecto_inventario_recursos);
        return "bsc_proyecto_inventario_recursos/form";
    }

    //http://localhost:8080/bsc_proyecto_inventario_recursos/grabar
    @PostMapping("grabar")
    public String save(@Valid bsc_proyecto_inventario_recursos_Entity p, Model model) {
        servicio.save(p);
        return "redirect:/bsc_proyecto_inventario_recursos/listar";
    }

    //http://localhost:8080/bsc_proyecto_inventario_recursos/eliminar/id
    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id, Model model) {
        servicio.delete(id);
        return "redirect:/bsc_proyecto_inventario_recursos/listar";
    }
}
