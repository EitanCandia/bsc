package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Data
@NoArgsConstructor
public class Dto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String alias;
	private String descripcion;
	private int orden;
	private float impuesto;
	private Date fecha_registro;
	public Dto( @JsonProperty("id")Long id, 
			 @JsonProperty("nombre")String nombre, 
			 @JsonProperty("alias")String alias, 
			 @JsonProperty("descripcion")String descripcion, 
			 @JsonProperty("orden")int orden, 
			 @JsonProperty("impuesto")float impuesto,
			 @JsonProperty("fecha_registro")Date fecha_registro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alias = alias;
		this.descripcion = descripcion;
		this.orden = orden;
		this.impuesto = impuesto;
		this.fecha_registro = fecha_registro;
	}
	
	
}