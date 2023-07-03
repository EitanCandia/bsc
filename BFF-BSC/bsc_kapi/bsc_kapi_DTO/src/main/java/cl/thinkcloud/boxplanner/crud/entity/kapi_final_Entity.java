package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bsc_kapi")
public class kapi_final_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "bscproyectoid")
    private int bscproyectoid;

    @NotNull
    @Column(name = "bscobjetivoid")
    private int bscobjetivoid;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "alias")
    private String alias;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "orden")
    private int orden;

    @Column(name = "formula")
    private String formula;

    @NotNull
    @Column(name = "fecharegistro")
    private Date fecharegistro;

    public kapi_final_Entity(
            @JsonProperty("id") int id,
            @JsonProperty("bscproyectoid") int bscproyectoid,
            @JsonProperty("bscobjetivoid") int bscobjetivoid,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("alias") String alias,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("orden") int orden,
            @JsonProperty("formula") String formula,
            @JsonProperty("fecharegistro") Date fecharegistro) {

        super();
        this.id = id;
        this.bscproyectoid = bscproyectoid;
        this.bscobjetivoid = bscobjetivoid;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden;
        this.formula = formula;
        this.fecharegistro = fecharegistro;
    }

}
