package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_proyecto_inventario_recursos")
public class bsc_proyecto_inventario_recursos_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "bsc_proyecto_inventario_pedido_id")
    private int bsc_proyecto_inventario_pedido_id;
    
    @NotNull
    @Column(name = "bsc_proyecto_inventario_item_id")
    private int bsc_proyecto_inventario_item_id;
    

    @NotNull
    @Column(name = "numero_fila")
    private int numero_fila;
    
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    
    @NotNull
    @Column(name = "cantidad_recepcionada")
    private int cantidad_recepcionada;
    
    @NotNull
    @Column(name = "solicitante_no_comprar")
    private boolean solicitante_no_comprar;
    
    @NotNull
    @Column(name = "revisor_rechazado")
    private boolean revisor_rechazado;
    
    @NotNull
    @Column(name = "observacion")
    private String observacion;
    
    @NotNull
    @Column(name = "fecha_registro")
    private String fecha_registro;


    
    public bsc_proyecto_inventario_recursos_Entity(@JsonProperty("id") int id,@JsonProperty("bsc_proyecto_inventario_pedido_id") int bsc_proyecto_inventario_pedido_id, 
    		@JsonProperty("bsc_proyecto_inventario_item_id") int bsc_proyecto_inventario_item_id,
    		@JsonProperty("numero_fila") int numero_fila,
    		@JsonProperty("cantidad") int cantidad,
    		@JsonProperty("cantidad_recepcionada") int cantidad_recepcionada,
    		@JsonProperty("solicitante_no_comprar") boolean solicitante_no_comprar,
    		@JsonProperty("revisor_rechazado") boolean revisor_rechazado,
    		@JsonProperty("observacion") String observacion,
    		@JsonProperty("fecha_registro") String fecha_registro
    		){
        super();
        this.id = id;
        this.bsc_proyecto_inventario_pedido_id = bsc_proyecto_inventario_pedido_id;
        this.bsc_proyecto_inventario_item_id = bsc_proyecto_inventario_item_id;
        this.numero_fila = numero_fila;
        this.cantidad = cantidad;
        this.cantidad_recepcionada = cantidad_recepcionada;
        this.solicitante_no_comprar = solicitante_no_comprar;
        this.revisor_rechazado = revisor_rechazado;
        this.observacion = observacion;
        this.fecha_registro = fecha_registro;
    }

}
