package cl.thinkcloud.kpimeta.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "kpi_meta")
public class KpiMetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bsc_kpi_id")
    private int bscKpiId;

    @NotBlank
    @Column(name = "periodo")
    private String periodo;

    @Column(name = "resultado", length = 500)
    private String resultado;

    @Column(name = "evaluacion", length = 500)
    private String evaluacion;

    @Column(name = "x1", length = 500)
    private String x1;

    @Column(name = "x2", length = 500)
    private String x2;

    @Lob
    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public KpiMetaEntity(@JsonProperty("id") int id, @JsonProperty("bsc_kpi_id") int bscKpiId, @JsonProperty("periodo") String periodo,
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
