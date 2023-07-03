package com.example.herramientas_desarrollo_proyecto.crud.entity;


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
@Entity
@Table(name="bsc_proyecto")

public class ProyectoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "org_persona_id_responsable", columnDefinition = "int(11)")
    private int org_persona_id_responsable;

    @Column(name="org_departamento_id_responsable", columnDefinition = "int(11)")
    private int org_departamento_id_responsable;

    @Column(name="bsc_tipo_proyecto_id", columnDefinition = "int(11)")
    private int bsc_tipo_proyecto_id;

    @Column(name="bsc_proceso_id", columnDefinition = "int(11)")
    private int bsc_proceso_id;


    @NotBlank
    @Size(max=50)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max=5)
    @Column(name = "alias")
    private String alias;


    @Size(max=500)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name="orden", columnDefinition = "int(11)")
    private int orden;
    
    @Size(max=5)
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "incluir")
    private boolean incluir;

    @Size(max=500)
    @Column(name = "objetivo_general")
    private String objetivo_general;

    @Column(name="presupuesto", columnDefinition = "int(11)")
    private int presupuesto;

    @Size(max=500)
    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public ProyectoEntity(
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
}
