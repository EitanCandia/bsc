package com.bff.bsc.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bff.bsc.dto.bsc_plan_de_cuentasDTO;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "bscplandecuentasClient", url = "${rest.endpoints.demoweb.url.bsc_plan_de_cuentas}")
public interface bsc_plan_de_cuentas {

    @GetMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST", produces = "application/json")
    public List<bsc_plan_de_cuentasDTO> findAll();

    @GetMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST/{id}", produces = "application/json")
    public Optional<bsc_plan_de_cuentasDTO> findById(@PathVariable("id") int id);

    @PostMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST", consumes = "application/json", produces = "application/json")
    public bsc_plan_de_cuentasDTO save(@RequestBody bsc_plan_de_cuentasDTO bsc_plan_de_cuentas);

    @PutMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST/{id}", produces = "application/json")
    public bsc_plan_de_cuentasDTO update(@PathVariable("id") int id, @RequestBody bsc_plan_de_cuentasDTO bsc_plan_de_cuentasDTO);

    @DeleteMapping(value = "/v1/bsc/bsc_plan_de_cuentas/REST/{id}", produces = "application/json")
    public void delete(@PathVariable("id") int id);

}