package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bff.bsc.dto.Proyecto_inventario_recursosDTO;




@FeignClient(name = "inventarioUnidadMicro", url = "${rest.endpoints.demoweb.url.bsc_inventario_unidad}")
public interface bsc_proyecto_inventario_recursos {

    @GetMapping(value = "v1/org/bsc_proyecto_inventario_recursos/REST", produces = "application/json")
    public List<Proyecto_inventario_recursosDTO> findAll();

    @GetMapping(value = "v1/org/bsc_proyecto_inventario_recursos/REST/{id}", produces = "application/json")
    public Optional<Proyecto_inventario_recursosDTO> findById(@PathVariable("id") int id);

    @DeleteMapping(value = "v1/org/bsc_proyecto_inventario_recursos/REST/{id}", produces = "application/json")
    public void deleteById(@PathVariable("id") int id);

    @PostMapping(value = "v1/org/bsc_proyecto_inventario_recursos/REST", consumes = "application/json", produces = "application/json")
    public Proyecto_inventario_recursosDTO save(@RequestBody Proyecto_inventario_recursosDTO bsc_proyecto_inventario_recursos);
    
    @PutMapping(value = "v1/org/bsc_proyecto_inventario_recursos/REST/{id}", consumes = "application/json", produces = "application/json")
    public Proyecto_inventario_recursosDTO update(@PathVariable("id") int id, @RequestBody Proyecto_inventario_recursosDTO bsc_proyecto_inventario_recursos);

}
