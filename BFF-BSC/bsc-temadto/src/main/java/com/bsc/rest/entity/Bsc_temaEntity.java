package com.bsc.rest.entity;


import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_tema")

public class Bsc_temaEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;	
    
 
    @Column(name = "bsc_perspectiva_id")
    private int bsc_perspectiva_id;
    
    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "alias")
    private String alias;
    
    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;
    
   
    @Column(name = "orden")
    private int orden;
    
   
    @Column(name = "fecha_registro")
    private Date fecha_registro;

	public Bsc_temaEntity(@JsonProperty("id") int id, @JsonProperty("bsc_perspectiva_id") int bsc_perspectiva_id, @JsonProperty("nombre") String nombre, @JsonProperty("alias") String alias,
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
