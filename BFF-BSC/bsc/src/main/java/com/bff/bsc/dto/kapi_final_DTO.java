package com.bff.bsc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class kapi_final_DTO {
    private int id;
    private int bscproyectoid;
    private int bscobjetivoid;
    private String descripcion;
    private int orden;
    private String formula;
    private Date fecharegistro;
    private String nombre;
    private String alias;

    public kapi_final_DTO(
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
