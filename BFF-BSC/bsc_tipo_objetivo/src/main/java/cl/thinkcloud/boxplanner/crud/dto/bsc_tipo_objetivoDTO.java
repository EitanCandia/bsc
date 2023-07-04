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
public class bsc_tipo_objetivoDTO {
	
	@Id
	private int id;
	
	@NotNull
	private int bsc_tipo_objetivo_id_padre;

	@NotNull
	private int nivel;
	
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
	
	public bsc_tipo_objetivoDTO(	
			@JsonProperty("id") int id,
			@JsonProperty("bsc_tipo_objetivo_id_padre") int bsc_tipo_objetivo_id_padre,
			@JsonProperty("nivel") int nivel,
			@JsonProperty("nombre") String nombre,
			@JsonProperty("alias") String alias,
			@JsonProperty("descripcion") String descripcion,
			@JsonProperty("orden") int orden,
			@JsonProperty("fecha_registro") Date fecha_registro
			) {
super();
this.id = id;
this.bsc_tipo_objetivo_id_padre = bsc_tipo_objetivo_id_padre;
this.nivel = nivel;
this.nombre = nombre;
this.alias = alias;
this.descripcion = descripcion;
this.orden = orden;
this.fecha_registro = fecha_registro;

}

	
	
	
	
	
	
	
	
	
	
	
	
}
