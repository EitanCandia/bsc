package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_ideas")
public class bsc_ideas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    @NotNull
    @Column(name = "incluir", nullable = false)
    private boolean incluir;

    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    private Date fecha_registro;

    



    public bsc_ideas(@JsonProperty("id") int id,
    @JsonProperty("nombre") String nombre, 
    @JsonProperty("descripcion") String descripcion,
    @JsonProperty("incluir") Boolean incluir,
    @JsonProperty("fecha_registro") Date fecha_registro ){
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.incluir = incluir;
        this.fecha_registro = fecha_registro;
    }

}
