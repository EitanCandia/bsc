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

import com.bff.bsc.dto.InventarioUnidadDTO;

@FeignClient(name = "inventarioUnidadMicro", url = "${rest.endpoints.demoweb.url.bsc_inventario_unidad}")
public interface bsc_inventario_unidad {

    @GetMapping(value = "v1/org/inventario-unidad/REST", produces = "application/json")
    public List<InventarioUnidadDTO> findAll();

    @GetMapping(value = "v1/org/inventario-unidad/REST/{id}", produces = "application/json")
    public Optional<InventarioUnidadDTO> findById(@PathVariable("id") int id);

    @DeleteMapping(value = "v1/org/inventario-unidad/REST/{id}", produces = "application/json")
    public void deleteById(@PathVariable("id") int id);

    @PostMapping(value = "v1/org/inventario-unidad/REST", consumes = "application/json", produces = "application/json")
    public InventarioUnidadDTO save(@RequestBody InventarioUnidadDTO inventarioUnidad);

    @PutMapping(value = "v1/org/inventario-unidad/REST/{id}", consumes = "application/json", produces = "application/json")
    public InventarioUnidadDTO update(@PathVariable("id") int id, @RequestBody InventarioUnidadDTO inventarioUnidad);

}
