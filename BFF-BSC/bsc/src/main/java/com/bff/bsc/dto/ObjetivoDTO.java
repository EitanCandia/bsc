package com.bff.bsc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor

public class ObjetivoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    
    private String alias;
    
    private String descripcion;
    
    private int orden;
    
    private String codigo;
    
    private Date fecha_registro;
    
    private int bsc_tema_id;
    
    private int bsc_tipo_objetivo_id;
    
    private int org_departamento_id_responsable;

    public ObjetivoDTO(@JsonProperty("id") int id,
    		@JsonProperty("nombre") String nombre,
    		@JsonProperty("alias") String alias,
    		@JsonProperty("descripcion") String descripcion,
    		@JsonProperty("orden") int orden,
    		@JsonProperty("codigo") String codigo,
    		@JsonProperty("fecha_registro") Date fecha_registro,
    		@JsonProperty("bsc_tema_id") int bsc_tema_id,
    		@JsonProperty("bsc_tipo_objetivo_id") int bsc_tipo_objetivo_id,
    		@JsonProperty("org_departamento_id_responsable") int org_departamento_id_responsable) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden; 
        this.codigo = codigo;
        this.fecha_registro = fecha_registro;
        this.bsc_tema_id = bsc_tema_id;
        this.bsc_tipo_objetivo_id = bsc_tipo_objetivo_id;
        this.org_departamento_id_responsable = org_departamento_id_responsable;
    }
}
