package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_r_proyecto_persona")
public class ProyectoPersonaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bsc_proyecto_id", nullable = false)
    private int bscProyectoId;

    @Min(value = 1, message = "El ID de persona debe ser mayor o igual a 1")
    @Column(name = "org_persona_id", nullable = false)
    private int orgPersonaId;
    
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public ProyectoPersonaEntity(@JsonProperty("bsc_proyecto_id") int bscProyectoId,
                                 @JsonProperty("org_persona_id") int orgPersonaId,
                                 @JsonProperty("fecha_registro") Date fechaRegistro) {
        super();
        this.bscProyectoId = bscProyectoId;
        this.orgPersonaId = orgPersonaId;
        this.fechaRegistro = fechaRegistro;
    }
}

