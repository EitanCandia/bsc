package com.bff.bsc.dto;

import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LugarDTO {
	
	@Id
	private int id;
	
	private int bsc_lugar_id_padre;
	
	//@NotNull
	private int nivel;
	
	//@NotBlank
	private String lugar;
	
	//@NotBlank
	private String edificio;
	
	//@NotBlank
	private String area;
	
	
	private int piso;
	
	//@NotBlank
	private String subarea;
	
	//@NotNull
	private Date fecha_registro;

	public LugarDTO(@JsonProperty("id") int id,
					@JsonProperty("bsc_lugar_id_padre") int bsc_lugar_id_padre,
					@JsonProperty("nivel") int nivel,
					@JsonProperty("lugar") String lugar,
					@JsonProperty("edificio") String edificio,
					@JsonProperty("area") String area,
					@JsonProperty("piso") int piso,
					@JsonProperty("subarea") String subarea,
					@JsonProperty("fecha_registro") Date fecha_registro) {
		super();
		this.id = id;
		this.bsc_lugar_id_padre = bsc_lugar_id_padre;
		this.nivel = nivel;
		this.lugar = lugar;
		this.edificio = edificio;
		this.area = area;
		this.piso = piso;
		this.subarea = subarea;
		this.fecha_registro = fecha_registro;
	}
	
	
	
}
