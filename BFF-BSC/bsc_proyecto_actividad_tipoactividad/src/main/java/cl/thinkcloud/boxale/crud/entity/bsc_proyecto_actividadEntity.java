package cl.thinkcloud.boxale.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_proyecto_actividad_tipoactividad")
public class bsc_proyecto_actividadEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;
    
    
    @Column(name = "nivel")
    private int nivel;
    
    @NotBlank
    @Column(name = "alias")
    private String alias;
    
    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;
    
    
    @Column(name = "orden")
    private int orden;
    
    @NotBlank
    @Column(name = "fecha_registro")
    private String fecha_registro;
    


    public bsc_proyecto_actividadEntity (@JsonProperty("id") int id,@JsonProperty("nombre") String nombre, @JsonProperty("nivel") int nivel
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
