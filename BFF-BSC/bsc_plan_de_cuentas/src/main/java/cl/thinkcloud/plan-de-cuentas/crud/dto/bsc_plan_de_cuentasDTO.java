package cl.thinkcloud.boxplanner.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor

public class bsc_plan_de_cuentasDTO {
    @Id
    private int id;

    @NotNull
    private String bscPlanDeCuentasIdPadre;

    private int nivel;

    @NotBlank
    private String codigo;

    @NotBlank
    private String nombre;

    private int presupuestoAnualFinal;

    private int presupuestoAnualOriginal;

    @NotBlank
    private String observacion;

    private boolean reasignable;

    @NotNull
    private boolean mostrarEnItems;

    @NotNull
    private Date fechaRegistro;


    public bsc_plan_de_cuentasDTO(	@JsonProperty("id") int id,
                        @JsonProperty("bscPlanDeCuentasIdPadre") String bscPlanDeCuentasIdPadre,
                        @JsonProperty("nivel") int nivel,
                        @JsonProperty("codigo") String codigo,
                        @JsonProperty("nombre") String nombre,
                        @JsonProperty("presupuesto_anual_final") int presupuestoAnualFinal,
                        @JsonProperty("presupuesto_anual_original") int presupuestoAnualOriginal,
                        @JsonProperty("observacion") String observacion,
                        @JsonProperty("reasignable") boolean reasignable,
    					@JsonProperty("mostrar_en_items") boolean mostrarEnItems,
    					@JsonProperty("fecha_registro") Date fechaRegistro) {
        super();
        this.id = id;
        this.bscPlanDeCuentasIdPadre = bscPlanDeCuentasIdPadre;
        this.nivel = nivel;
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuestoAnualFinal = presupuestoAnualFinal;
        this.presupuestoAnualOriginal = presupuestoAnualOriginal;
        this.observacion = observacion;
        this.reasignable = reasignable;
        this.mostrarEnItems = mostrarEnItems;
        this.fechaRegistro = fechaRegistro;
    }

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}

}
