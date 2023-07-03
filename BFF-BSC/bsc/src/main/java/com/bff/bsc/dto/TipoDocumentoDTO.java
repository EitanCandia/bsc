package com.bff.bsc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
public class TipoDocumentoDTO{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String alias;
	private String descripcion;
	private int orden;
	private float impuesto;
	private Date fecha_registro;
	public TipoDocumentoDTO( @JsonProperty("id")Long id, 
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public float getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
		
}
