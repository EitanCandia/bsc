package cl.thinkcloud.inventariounidad.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
public class InventarioUnidadDTO {
    private int id;

    private String nombre;

    private String alias;

    private String descripcion;

    private int orden;

    private Date fechaRegistro;

    public InventarioUnidadDTO(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre,
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
