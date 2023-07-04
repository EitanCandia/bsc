package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@Entity
@Table(name="persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;
    
    @NotBlank
    @Column(name = "apellido")
    private String apellido;



    public PersonaEntity(@JsonProperty("id") int id,@JsonProperty("nombre") String nombre, @JsonProperty("apellido") String apellido) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
