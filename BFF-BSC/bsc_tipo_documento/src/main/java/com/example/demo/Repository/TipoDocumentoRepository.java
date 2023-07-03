package com.example.demo.Repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{
	@Query("SELECT td FROM bsc_tipo_documento td WHERE td.id=?")
	public TipoDocumento getById(Long id);
}