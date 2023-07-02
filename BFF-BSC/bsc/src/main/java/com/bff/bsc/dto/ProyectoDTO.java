package com.bff.bsc.dto;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProyectoDTO{

    @Id
    private int id;
    
    private int org_persona_id_responsable;

    private int org_departamento_id_responsable;

    private int bsc_tipo_proyecto_id;

    private int bsc_proceso_id;


    @NotBlank
    private String nombre;
    
    private String alias;


    private String descripcion;
    
    private int orden;
    

    private String codigo;


    private boolean incluir;


    private String objetivo_general;

    private int presupuesto;


    private String observaciones;

    private Date fechaRegistro;

    public ProyectoDTO(
            @JsonProperty("id") int id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("org_persona_id_responsable") int org_persona_id_responsable,
            @JsonProperty("org_departamento_id_responsable") int org_departamento_id_responsable,
            @JsonProperty("bsc_tipo_proyecto_id") int bsc_tipo_proyecto_id,
            @JsonProperty("bsc_proceso_id") int bsc_proceso_id,
            @JsonProperty("alias") String alias,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("orden") int orden,
            @JsonProperty("codigo") String codigo,
            @JsonProperty("incluir") boolean incluir,
            @JsonProperty("objetivo_general") String objetivo_general,
            @JsonProperty("presupuesto") int presupuesto,
            @JsonProperty("observaciones") String observaciones,
            @JsonProperty("fecha_registro") Date fechaRegistro
    ) {
        this.id = id;
        this.nombre = nombre;
        this.org_persona_id_responsable = org_persona_id_responsable;
        this.org_departamento_id_responsable = org_departamento_id_responsable;
        this.bsc_tipo_proyecto_id = bsc_tipo_proyecto_id;
        this.bsc_proceso_id = bsc_proceso_id;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden;
        this.codigo = codigo;
        this.incluir = incluir;
        this.objetivo_general = objetivo_general;
        this.presupuesto = presupuesto;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrg_persona_id_responsable() {
		return org_persona_id_responsable;
	}

	public void setOrg_persona_id_responsable(int org_persona_id_responsable) {
		this.org_persona_id_responsable = org_persona_id_responsable;
	}

	public int getOrg_departamento_id_responsable() {
		return org_departamento_id_responsable;
	}

	public void setOrg_departamento_id_responsable(int org_departamento_id_responsable) {
		this.org_departamento_id_responsable = org_departamento_id_responsable;
	}

	public int getBsc_tipo_proyecto_id() {
		return bsc_tipo_proyecto_id;
	}

	public void setBsc_tipo_proyecto_id(int bsc_tipo_proyecto_id) {
		this.bsc_tipo_proyecto_id = bsc_tipo_proyecto_id;
	}

	public int getBsc_proceso_id() {
		return bsc_proceso_id;
	}

	public void setBsc_proceso_id(int bsc_proceso_id) {
		this.bsc_proceso_id = bsc_proceso_id;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isIncluir() {
		return incluir;
	}

	public void setIncluir(boolean incluir) {
		this.incluir = incluir;
	}

	public String getObjetivo_general() {
		return objetivo_general;
	}

	public void setObjetivo_general(String objetivo_general) {
		this.objetivo_general = objetivo_general;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

   
}
