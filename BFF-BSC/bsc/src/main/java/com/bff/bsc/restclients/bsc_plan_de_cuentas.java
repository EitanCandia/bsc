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


import com.bff.bsc.dto.bsc_plan_de_cuentasDTO;
import com.bff.bsc.dto.ideasDTO;

@FeignClient(name = "bsc_plan_de_cuentasClient", url = "${rest.endpoints.demoweb.url.bsc_plan_de_cuentas}")
public interface bsc_plan_de_cuentas {

		@GetMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST", produces = "application/json")
	    public List<bsc_plan_de_cuentasDTO> findAll();
		
		@GetMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST/{id}", produces = "application/json")
	    public Optional<bsc_plan_de_cuentasDTO> findById(@PathVariable("id") int id);
	    
		@PostMapping(value = "/v1/org/bsc_plan_de_cuentas/REST/{id}", consumes = "application/json", produces = "application/json")
    	public bsc_plan_de_cuentasDTO save(bsc_plan_de_cuentasDTO bsc_plan_de_cuentas);

	    @PutMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST/{id}", produces = "application/json")
	    public bsc_plan_de_cuentasDTO update(@PathVariable("id") int id, @RequestBody bsc_plan_de_cuentas bsc_plan_de_cuentasDTO);
	    
	    @ResponseBody @DeleteMapping("/v1/bsc/bsc_plan_de_cuentas/REST/{id}")
	    public void delete(@PathVariable("id") int id);
}

