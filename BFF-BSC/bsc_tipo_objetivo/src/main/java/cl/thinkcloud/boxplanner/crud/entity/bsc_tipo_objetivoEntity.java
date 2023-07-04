package cl.thinkcloud.boxplanner.crud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_tipo_objetivo_id_padre")
public class bsc_tipo_objetivoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "bsc_tipo_objetivo_id_padre")
	private int bsc_tipo_objetivo_id_padre;
	
	@NotNull
	@Column(name = "nivel")
	private int nivel;
	
	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	
    @NotBlank
	@Column(name = "alias")
	private String alias;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@Column(name = "orden")
	private int orden;
	
	@NotNull
	@Column(name = "fecha_registro")
	private Date fecha_registro;
	

	public bsc_tipo_objetivoEntity(int id, int bsc_tipo_objetivo_id_padre, int nivel, String nombre, String alias, String descripcion, int orden,
			Date fecha_registro) {
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
