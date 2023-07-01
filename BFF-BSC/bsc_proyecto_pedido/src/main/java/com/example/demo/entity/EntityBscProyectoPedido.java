package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="bsc_proyecto_pedido")

@Data
@NoArgsConstructor

public class EntityBscProyectoPedido {
    @Id
 
    private int id;
    
 
  
    private Date fecha_registro;
    
    
   
    private Date fecha_proceso;

    
  
    private Date fecha_cierre;
    
   @NotBlank
    private String descripcion;
    
    
   @NotBlank
    private String observaciones;
    
    
    
    public EntityBscProyectoPedido(
    	@JsonProperty("id") int id,
    	@JsonProperty("fecha_registro") Date fecha_registro, 
    	@JsonProperty("fecha_proceso") Date fecha_proceso,
    	@JsonProperty("fecha_cierre") Date fecha_cierre,
    	@JsonProperty("descripcion") String descripcion, 
    	@JsonProperty("observaciones") String observaciones) {
        super();
        this.id = id;
        this.fecha_registro = fecha_registro;
        this.fecha_proceso = fecha_proceso;
        this.fecha_cierre = fecha_cierre;
        
        this.descripcion = descripcion;
        this.observaciones = observaciones;
    }

}

