package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bsc_inventario_unidad")
public class InventarioUnidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "alias", length = 5)
    private String alias;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "orden")
    private int orden;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public InventarioUnidadEntity(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre,
            @JsonProperty("alias") String alias,
            @JsonProperty("descripcion") String descripcion, @JsonProperty("orden") int orden,
            @JsonProperty("fecha_registro") Date fechaRegistro) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.alias = alias;
        this.descripcion = descripcion;
        this.orden = orden;
        this.fechaRegistro = fechaRegistro;
    }
}
