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
import org.springframework.web.bind.annotation.ResponseBody;


import com.bff.bsc.dto.Inventario_itemDTO;
import com.bff.bsc.dto.ProyectoPersonaDTO;

@FeignClient(name = "inventarioItemClient", url = "${rest.endpoints.demoweb.url.bsc_inventario_item}")
public interface Bsc_inventario_item {

		@GetMapping(value = "/v1/bsc/inventario_item/REST", produces = "application/json")
	    public List<Inventario_itemDTO> findAll();
		
		@GetMapping(value = "/v1/bsc/inventario_item/REST/{id}", produces = "application/json")
	    public Optional<Inventario_itemDTO> findById(@PathVariable("id") int id);
	    
	    @ResponseBody @PostMapping(value = "/v1/bsc/inventario_item/REST", produces = "application/json")
	    public Inventario_itemDTO save(Inventario_itemDTO inventarioItem);
	    
	    @PutMapping(value = "/v1/bsc/inventario_item/REST/{id}", produces = "application/json")
	    public Inventario_itemDTO update(@PathVariable("id") int id, @RequestBody Inventario_itemDTO inventarioItemDTO);
	    
	    @ResponseBody @DeleteMapping("/v1/bsc/inventario_item/REST/{id}")
	    public void delete(@PathVariable("id") int id);
}