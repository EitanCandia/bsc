package cl.thinkcloud.boxplanner.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class ProyectoPersonaDTO {
    
    @NotNull
    private int bscProyectoId;

    @NotNull
    private int orgPersonaId;
    
    @NotNull
    private Date fechaRegistro;

    public ProyectoPersonaDTO(@JsonProperty("bsc_proyecto_id") int bscProyectoId,
                              @JsonProperty("org_persona_id") int orgPersonaId,
                              @JsonProperty("fecha_registro") Date fechaRegistro) {
        super();
        this.bscProyectoId = bscProyectoId;
        this.orgPersonaId = orgPersonaId;
        this.fechaRegistro = fechaRegistro;
    }
}
