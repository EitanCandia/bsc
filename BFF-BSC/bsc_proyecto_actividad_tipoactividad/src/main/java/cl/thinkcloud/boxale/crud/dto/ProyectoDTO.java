package cl.thinkcloud.boxale.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class ProyectoDTO {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @NotBlank
	    private String nombre;
	    
	    
	    
	    private int nivel;
	    
	    @NotBlank
	    private String alias;
	    
	    @NotBlank
	    private String descripcion;
	    
	    
	    
	    private int orden;
	    
	    @NotBlank
	    private String fecha_registro;
	    


	    public ProyectoDTO (@JsonProperty("id") int id,@JsonProperty("nombre") String nombre, @JsonProperty("nivel") int nivel
	    		,@JsonProperty("alias") String alias, @JsonProperty("descripcion") String descripcion,@JsonProperty("orden") int orden,@JsonProperty("fecha_registro") String
	    		fecha_registro) {
	        super();
	        this.id = id;
	        this.nombre = nombre;
	        this.nivel = nivel;
	        this.alias = alias;
	        this.descripcion = descripcion;
	        this.orden = orden;
	        this.fecha_registro = fecha_registro;
	    }

}
