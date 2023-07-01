package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_lugar")
public class LugarEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "bsc_lugar_id_padre")
	private int bsc_lugar_id_padre;
	
	//@NotNull
	@Column(name = "nivel")
	private int nivel;
	
	//@NotBlank
	@Column(name = "lugar")
	private String lugar;
	
	//@NotBlank
	@Column(name = "edificio")
	private String edificio;
	
	//@NotBlank
	@Column(name = "area")
	private String area;
	
	
	@Column(name = "piso")
	private int piso;
	
	//@NotBlank
	@Column(name = "subarea")
	private String subarea;
	
	//@NotNull
	@Column(name = "fecha_registro")
	private Date fecha_registro;

	public LugarEntity(@JsonProperty("id") int id,@JsonProperty("bsc_lugar_id_padre") int bsc_lugar_id_padre,@JsonProperty("nivel") int nivel,
			@JsonProperty("lugar") String lugar,@JsonProperty("edificio") String edificio,@JsonProperty("area") String area,@JsonProperty("piso") int piso,
			@JsonProperty("subarea") String subarea,@JsonProperty("fecha_registro") Date fecha_registro) {
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
