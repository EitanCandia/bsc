package com.bff.bsc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.sql.Date;

@Data
@NoArgsConstructor
public class SituacionDTO{
	
	@Id
	private int id_bsc_situacion_departamento_idea_proyecto;
	private int bsc_r_situacion_departamento_id;
	private int bsc_idea_id;
	private int bsc_proyecto_id;
	private int cantidad_votos;
	private boolean incluir;
	private Date fecha_registro;
	
	public SituacionDTO(@JsonProperty("id_bsc_situacion_departamento_idea_proyecto") int id_bsc_situacion_departamento_idea_proyecto, 
			 			@JsonProperty("bsc_r_situacion_departamento_id") int bsc_r_situacion_departamento_id,
			 			@JsonProperty("bsc_idea_id") int bsc_idea_id,
			 			@JsonProperty("bsc_proyecto_id") int bsc_proyecto_id, 
			 			@JsonProperty("cantidad_votos") int cantidad_votos, 
			 			@JsonProperty("incluir") boolean incluir, 
			 			@JsonProperty("fecha_registro") Date fecha_registro) {
		 super();
		 this.id_bsc_situacion_departamento_idea_proyecto = id_bsc_situacion_departamento_idea_proyecto;
		 this.bsc_r_situacion_departamento_id = bsc_r_situacion_departamento_id;
		 this.bsc_idea_id = bsc_idea_id;
		 this.bsc_proyecto_id = bsc_proyecto_id;
		 this.cantidad_votos = cantidad_votos;
		 this.incluir = incluir;
		 this.fecha_registro = fecha_registro;
	 }
	 	 
}