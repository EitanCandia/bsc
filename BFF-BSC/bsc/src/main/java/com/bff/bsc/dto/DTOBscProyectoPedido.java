package com.bff.bsc.dto;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_proyecto_pedido")
public class DTOBscProyectoPedido {
    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private Date fecha_cierre;
    private Date fecha_proceso;
    private Date fecha_registro;
    private String observaciones;
    
    
    public DTOBscProyectoPedido(
    	@JsonProperty("id") int id,
    	@JsonProperty("descripcion") String descripcion, 
    	@JsonProperty("fecha_cierre") Date fecha_cierre,
    	@JsonProperty("fecha_proceso") Date fecha_proceso,
    	@JsonProperty("fecha_registro") Date fecha_registro, 
    	@JsonProperty("observaciones") String observaciones) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.fecha_cierre = fecha_cierre;
        this.fecha_proceso = fecha_proceso;
        this.fecha_registro = fecha_registro;
        this.observaciones = observaciones;
    }



	

}

