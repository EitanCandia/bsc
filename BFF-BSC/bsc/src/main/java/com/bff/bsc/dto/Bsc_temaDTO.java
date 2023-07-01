package com.bff.bsc.dto;


import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bsc_temaDTO {
	
	//@Id
    private int id;	
    
    private int bsc_perspectiva_id;
    
    @NotBlank
    private String nombre;

    @NotBlank
    private String alias;
    
    @NotBlank
    private String descripcion;
    
    private int orden;
    

    private Date fecha_registro;

	public Bsc_temaDTO(@JsonProperty("id") int id, @JsonProperty("bsc_perspectiva_id") int bsc_perspectiva_id, @JsonProperty("nombre") String nombre, @JsonProperty("alias") String alias,
			@JsonProperty("descripcion") String descripcion,@JsonProperty("orden") int orden, @JsonProperty("fecha_registro") Date fecha_registro) {
		super();
		this.id = id;
		this.bsc_perspectiva_id = bsc_perspectiva_id;
		this.nombre = nombre;
		this.alias = alias;
		this.descripcion = descripcion;
		this.orden = orden;
		this.fecha_registro = fecha_registro;
	}
}
