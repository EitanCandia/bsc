package com.bff.bsc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
public class ideasDTO {

    @NotNull
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @NotNull
    private Boolean incluir;

    @NotNull
    private Date fecha_registro;

    public ideasDTO(@JsonProperty("id") int id,
                    @JsonProperty("nombre") String nombre,
                    @JsonProperty("descripcion") String descripcion,
                    @JsonProperty("incluir") Boolean incluir,
                    @JsonProperty("fecha_registro") Date fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion= descripcion;
        this.incluir = incluir;
        this.fecha_registro = fecha_registro;
    }
}

