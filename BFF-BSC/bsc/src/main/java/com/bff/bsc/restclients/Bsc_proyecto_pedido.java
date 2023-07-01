package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.DTOBscProyectoPedido;



@FeignClient(name = "proyectoPedido", url = "${rest.endpoints.demoweb.url.bsc_proyecto_pedido}")

		public interface Bsc_proyecto_pedido {


			@GetMapping(value = "/v1/bsc/proyecto_pedido/REST", produces = "application/json")
			public List<DTOBscProyectoPedido> findAll();
			
			@GetMapping(value = "/v1/bsc/proyecto_pedido/REST/{id}", produces = "application/json")
		    public Optional<DTOBscProyectoPedido> findById(@PathVariable("id") int id);
		    
		    @ResponseBody @PostMapping(value = "/v1/bsc/proyecto_pedido/REST", produces = "application/json")
		    public DTOBscProyectoPedido save(DTOBscProyectoPedido dtobpp);
		    
		    @ResponseBody @DeleteMapping("/v1/bsc/proyecto_pedido/REST/{id}")
		    public void delete(@PathVariable("id") int id);

			

		 
			
}
