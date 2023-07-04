package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="est_modelo")
public class Est_modeloEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @NotNull
    @Column(name = "aplica_solo_a_departamentos")
    private int aplica_solo_a_departamentos;
    
    @NotBlank
    @Column(name = "nombre")
    private String nombre;
    
    @NotBlank
    @Column(name = "alias")
    private String alias;
    
    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;
    
    @NotNull
    @Column(name = "orden")
    private int orden;
    
    @NotNull
    @Column(name = "fecha_registro")
    private Date fecha_registro;



    public Est_modeloEntity(@JsonProperty("id") int id, 
    		@JsonProperty("aplica_solo_a_departamentos") int aplica_solo_a_departamentos, 
    		@JsonProperty("nivel") int nivel,
    		@JsonProperty("nombre") String nombre,
    		@JsonProperty("alias") String alias,
    		@JsonProperty("descripcion") String descripcion,
    		@JsonProperty("orden") int orden,
    		@JsonProperty("fecha_registro") Date fecha_registro) {
        super();
        this.id = id;
        this.aplica_solo_a_departamentos = aplica_solo_a_departamentos;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden;
        this.fecha_registro = fecha_registro;
    }

	
}
