package com.bff.bsc.restclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bff.bsc.dto.TipoDocumentoDTO;

@FeignClient(name = "tipodocumentoClient", url = "${rest.endpoints.demoweb.url.bsc_tipo_documento}")
public interface bsc_tipo_documento {

	@GetMapping(value = "/v1/bsc/tipo-documento/REST", produces = "application/json")
    public List<TipoDocumentoDTO> findAll();
	
	@GetMapping(value = "/v1/bsc/tipo-documento/REST/{id}", produces = "application/json")
    public Optional<TipoDocumentoDTO> findById(@PathVariable("id") long id);
    
    @ResponseBody @PostMapping(value = "/v1/bsc/tipo-documento/REST", produces = "application/json")
    public TipoDocumentoDTO save(TipoDocumentoDTO si);
    
    @ResponseBody @DeleteMapping("/v1/bsc/tipo-documento/REST/{id}")
    public void delete(@PathVariable("id") long id);
}
