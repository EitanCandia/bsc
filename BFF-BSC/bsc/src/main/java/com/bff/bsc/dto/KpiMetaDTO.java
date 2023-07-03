package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
public class KpiMetaDTO {
    private int id;

    private int bscKpiId;

    @NotBlank
    private String periodo;

    private String resultado;

    private String evaluacion;

    private String x1;

    private String x2;

    private String observacion;

    private Date fechaRegistro;

    public KpiMetaDTO(@JsonProperty("id") int id, @JsonProperty("bsc_kpi_id") int bscKpiId, @JsonProperty("periodo") String periodo,
                      @JsonProperty("resultado") String resultado, @JsonProperty("evaluacion") String evaluacion,
                      @JsonProperty("x1") String x1, @JsonProperty("x2") String x2, @JsonProperty("observacion") String observacion,
                      @JsonProperty("fecha_registro") Date fechaRegistro) {
        super();
        this.id = id;
        this.bscKpiId = bscKpiId;
        this.periodo = periodo;
        this.resultado = resultado;
        this.evaluacion = evaluacion;
        this.x1 = x1;
        this.x2 = x2;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
    }
}
