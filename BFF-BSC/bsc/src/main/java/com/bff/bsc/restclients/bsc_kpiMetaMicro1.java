package com.example.demo.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.KpiMetaDTO;

@FeignClient(name = "kpiMetaMicro", url = "${rest.endpoints.demoweb.url.bsc_kpi_meta}")
public interface bsc_kpiMetaMicro1 {
	///v1/bff1/micro1
	
	
	@GetMapping(value = "v1/org/kpi-meta/REST", produces = "application/json")
    public List<KpiMetaDTO> findAll();
	
	@GetMapping(value = "v1/org/kpi-meta/REST/{id}", produces = "application/json")
    public Optional<KpiMetaDTO> findById(@PathVariable("id") int id);
    //public PersonaDTO save(PersonaDTO persona);
    
    @DeleteMapping(value = "v1/org/kpi-meta/REST/{id}", produces = "application/json")
    public void kpiMetadelete(@PathVariable("id") int id);

    
    @PostMapping(value = "v1/org/kpi-meta/REST", consumes = "application/json", produces = "application/json")
    public KpiMetaDTO kpiMetaSave(@RequestBody KpiMetaDTO kpiMeta);

    @PutMapping(value = "v1/org/kpi-meta/REST/{id}", consumes = "application/json", produces = "application/json")
    public KpiMetaDTO kpiMetaUpdate(@PathVariable("id") int id, @RequestBody KpiMetaDTO kpiMeta);

}
