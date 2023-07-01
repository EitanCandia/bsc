package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.LugarDTO;

@FeignClient(name= "lugarClient", url= "${rest.endpoints.demoweb.url.bsc_lugar}")
public interface Bsc_lugar {
	
@GetMapping(value = "/v1/bsc/bsc_lugar/REST", produces ="application/json")
public List<LugarDTO> findAll();

@GetMapping(value = "/v1/bsc/bsc_lugar/REST/{id}", produces = "application/json")
public Optional<LugarDTO> findById(@PathVariable("id") int id);

@ResponseBody @PostMapping(value = "/v1/bsc/bsc_lugar/REST", produces = "application/json")
public LugarDTO save(LugarDTO pa);

@ResponseBody @DeleteMapping("/v1/bsc/bsc_lugar/REST/{id}")
public void delete(@PathVariable("id") int id);
}
