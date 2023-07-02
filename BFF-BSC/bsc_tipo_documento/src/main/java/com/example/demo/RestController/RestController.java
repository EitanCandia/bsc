package com.example.demo.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

import com.example.demo.Model.TipoDocumento;
import com.example.demo.Repository.TipoDocumentoRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private final TipoDocumentoRepository bsc_tipo_documento;
	private CrudRepository<TipoDocumento, Long> bsc_tipo_documentos;
	
	RestController(TipoDocumentoRepository bsc_tipo_documento){

			this.bsc_tipo_documento = bsc_tipo_documento;
	}

	@PostMapping("/v1/bsc/tipo-documento/REST")
	public TipoDocumento createTipoDocumento(@RequestBody TipoDocumento tipo_documento) {

			return bsc_tipo_documento.save(tipo_documento);
	}	
	@GetMapping("/v1/bsc/tipo-documento/REST")
	List<TipoDocumento> all() {
		    return bsc_tipo_documento.findAll();
		  }
	
	@GetMapping("/v1/bsc/bsctipodocumento/{id}")
	public TipoDocumento getTipoDocumento(@PathVariable Long id) {
		return bsc_tipo_documento.getById(id);
	}
	@PutMapping("/api/v1/bsctipodocumento/{id}")
	public TipoDocumento putTipoDocumento(@PathVariable Long id,@RequestBody TipoDocumento tipo_documento){
		
		Optional<TipoDocumento> OptionalnuevoTipo = bsc_tipo_documento.findById(id);
		if(OptionalnuevoTipo.isPresent())
		{	
			tipo_documento = OptionalnuevoTipo.get();
			tipo_documento.setDescripcion(OptionalnuevoTipo.get().getDescripcion());
			return bsc_tipo_documento.save(tipo_documento);	
		}else return null;
		
	}
	
	@DeleteMapping("/v1/bsc/bsctipodocumento/{id}")
	public void deleteOneTipoDocument(@PathVariable Long id) {
		bsc_tipo_documento.deleteById(id);
	}
}
