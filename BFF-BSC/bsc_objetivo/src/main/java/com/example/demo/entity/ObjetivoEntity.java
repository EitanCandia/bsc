package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_objetivo")
public class ObjetivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "alias", nullable = false)
    private String alias;
    
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    
    @Column(name = "orden", nullable = true)
    private int orden;
    
    @Column(name = "codigo", nullable = false)
    private String codigo;
    
    @Column(name = "fecha_registro", nullable = false)
    private Date fecha_registro;
    
    @Column(name = "bsc_tema_id", nullable = true)
    private int bsc_tema_id;
    
    @Column(name = "bsc_tipo_objetivo_id", nullable = false)
    private int bsc_tipo_objetivo_id;
    
    @Column(name = "org_departamento_id_responsable", nullable = true)
    private int org_departamento_id_responsable;

    public ObjetivoEntity(@JsonProperty("id") int id,
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
