package com.tomas.msr.entity;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@Entity
@Table(name="bsc_proyecto_actividad")
public class Proyecto_ActividadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Column(name = "bsc_proyecto_objetivo_especifico_id")
	private int bsc_proyecto_objetivo_especifico_id;
	
	
	@Column(name = "org_persona_id_registrador_por")
	private int org_persona_id_registrador_por;
	

	@Column(name = "org_persona_id_responsable")
	private int org_persona_id_responsable;
	

	@Column(name = "col_pdca_id")
	private int col_pdca_id;
	

	@Column(name = "bsc_proyecto_actividad_tipoactividad_id")
	private int bsc_proyecto_actividad_tipoactividad_id;
	
	
	@Column(name = "org_ambito_id")
	private int org_ambito_id;
	

	@Column(name = "org_centro_costo_id")
	private int org_centro_costo_id;
	

	@Column(name = "bsc_lugar_id")
	private int bsc_lugar_id;
	
	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha_registro")
	private Date fecha_registro;
	
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Column(name = "fecha_termino")
	private Date fecha_termino;
	
	@Column(name = "incluir_en_pao")
	private boolean incluir_en_pao;
	
	@Column(name = "porcentaje_completado")
	private int porcentaje_completado;
	
	
	@Column(name = "observacion_control_gestion")
	private String observacion_control_gestion;

	public Proyecto_ActividadEntity(
			@JsonProperty("id") int id, 
			@JsonProperty("bsc_proyecto_objetivo_especifico_id") int bsc_proyecto_objetivo_especifico_id,
			@JsonProperty("org_persona_id_registrador_por") int org_persona_id_registrador_por,
			@JsonProperty("org_persona_id_responsable") int org_persona_id_responsable,
			@JsonProperty("col_pdca_id") int col_pdca_id,
			@JsonProperty("bsc_proyecto_actividad_tipoactividad_id") int bsc_proyecto_actividad_tipoactividad_id,
			@JsonProperty("org_ambito_id") int org_ambito_id,
			@JsonProperty("org_centro_costo_id") int org_centro_costo_id,
			@JsonProperty("bsc_lugar_id") int bsc_lugar_id,
			@JsonProperty("nombre") String nombre, 
			@JsonProperty("descripcion") String descripcion,
			@JsonProperty("fecha_registro") Date fecha_registro, 
			@JsonProperty("fecha_inicio") Date fecha_inicio,
			@JsonProperty("fecha_termino") Date fecha_termino,
			@JsonProperty("incluir_en_pao") boolean incluir_en_pao,
			@JsonProperty("porcentaje_completado") int porcentaje_completado,
			@JsonProperty("observacion_control_gestion") String observacion_control_gestion) {
		super();
		this.id = id;
		this.bsc_proyecto_objetivo_especifico_id = bsc_proyecto_objetivo_especifico_id;
		this.org_persona_id_registrador_por = org_persona_id_registrador_por;
		this.org_persona_id_responsable = org_persona_id_responsable;
		this.col_pdca_id = col_pdca_id;
		this.bsc_proyecto_actividad_tipoactividad_id = bsc_proyecto_actividad_tipoactividad_id;
		this.org_ambito_id= org_ambito_id;
		this.org_centro_costo_id = org_centro_costo_id;
		this.bsc_lugar_id = bsc_lugar_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_registro = fecha_registro;
		this.fecha_inicio = fecha_inicio;
		this.fecha_termino = fecha_termino;
		this.incluir_en_pao = incluir_en_pao;
		this.porcentaje_completado = porcentaje_completado;
		this.observacion_control_gestion = observacion_control_gestion;
	}
	
}