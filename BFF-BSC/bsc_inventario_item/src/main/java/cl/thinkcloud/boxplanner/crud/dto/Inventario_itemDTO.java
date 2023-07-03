package cl.thinkcloud.boxplanner.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor

public class Inventario_itemDTO {
    @Id
    private int id;
    
    @NotNull
    private int orgPersonaIdRegistradoPor;
    
    @NotNull
    private int bscPlanDeCuentasId;
    
    @NotNull
    private int bscProveedorId;
    
    @NotNull
    private int bscInventarioUnidadId;
    
    @NotBlank
    private String nombre;
	
	@NotBlank
	private String alias;
	
	@NotBlank
	private String descripcion;
	
	@NotNull
	private Integer precioConImpuesto;
	
	@NotBlank
	private String url;
	
	@NotBlank
    private String observacion;
	
	@NotNull
    private LocalDate fecha_registro;
	
	public Inventario_itemDTO(
			@JsonProperty("id") int id,
			@JsonProperty("org_persona_id_registrado_por") int orgPersonaIdRegistradoPor,
			@JsonProperty("bsc_plan_de_cuentas_id") int bscPlanDeCuentasId,
			@JsonProperty("bsc_proveedor_id") int bscProveedorId,
			@JsonProperty("bsc_inventario_unidad_id") int bscInventarioUnidadId,
			@JsonProperty("nombre") String nombre,
			@JsonProperty("alias") String alias,
			@JsonProperty("descripcion") String descripcion,
			@JsonProperty("precio_con_impuesto") int precioConImpuesto,
			@JsonProperty("url") String url,
			@JsonProperty("observacion") String observacion,
			@JsonProperty("fecha_registro") LocalDate fecha_registro) {
		super();
		this.id = id;
		this.orgPersonaIdRegistradoPor = orgPersonaIdRegistradoPor;
		this.bscPlanDeCuentasId=bscPlanDeCuentasId;
		this.bscProveedorId=bscProveedorId;
		this.bscInventarioUnidadId=bscInventarioUnidadId;
		this.nombre = nombre;
		this.alias = alias;
		this.descripcion = descripcion;
		this.precioConImpuesto=precioConImpuesto;
		this.url=url;
		this.observacion=observacion;
		this.fecha_registro = fecha_registro;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}

}
