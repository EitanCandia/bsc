package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.ObjetivoDTO;

@FeignClient(name = "objetivoClient", url = "${rest.endpoints.demoweb.url.bsc_objetivo}")
public interface Bsc_objetivo{


@GetMapping(value = "/v1/bsc/bsc_objetivo/REST", produces = "application/json")
public List<ObjetivoDTO> findAll();

@GetMapping(value = "/v1/bsc/bsc_objetivo/REST/{id}", produces = "application/json")
public Optional<ObjetivoDTO> findById(@PathVariable("id") int id);

@ResponseBody @PostMapping(value = "/v1/bsc/bsc_objetivo/REST", produces = "application/json")
public ObjetivoDTO save(ObjetivoDTO pa);

@ResponseBody @DeleteMapping("/v1/bsc/bsc_objetivo/REST/{id}")
public void delete(@PathVariable("id") int id);
}
