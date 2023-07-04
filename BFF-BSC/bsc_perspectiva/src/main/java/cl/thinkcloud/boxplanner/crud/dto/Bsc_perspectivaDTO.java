package cl.thinkcloud.boxplanner.crud.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Bsc_perspectivaDTO {
	
	@Id
	private int id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotBlank
	private String descripcion;
	
	@NotNull
	private int orden;
	
	@NotNull
	private Date fecha_registro;
	
	public Bsc_perspectivaDTO(	
			@JsonProperty("id") int id,
			@JsonProperty("nombre") String nombre,
			@JsonProperty("alias") String alias,
			@JsonProperty("descripcion") String descripcion,
			@JsonProperty("orden") int orden,
			@JsonProperty("fecha_registro") Date fecha_registro
			) {
super();
this.id = id;
this.nombre = nombre;
this.alias = alias;
this.descripcion = descripcion;
this.orden = orden;
this.fecha_registro = fecha_registro;

}

	
	
	
	
	
	
	
	
	
	
	
	
}
