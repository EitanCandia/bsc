package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_inventario_item")
public class Inventario_itemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
	@Column(name = "org_persona_id_registrado_por")
    private int orgPersonaIdRegistradoPor;
    
    @NotNull
	@Column(name = "bsc_plan_de_cuentas_id")
    private int bscPlanDeCuentasId;
    
    @NotNull
	@Column(name = "bsc_proveedor_id")
    private int bscProveedorId;
    
    @NotNull
	@Column(name = "bsc_inventario_unidad_id")
    private int bscInventarioUnidadId;
    
    @NotBlank
    @Column(name = "nombre")
    private String nombre;
	
	@NotBlank
	@Column(name = "alias")
	private String alias;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "precio_con_impuesto")
	private Integer precioConImpuesto;
	
	@NotBlank
	@Column(name = "url")
	private String url;
	
	@NotBlank
	@Column(name = "observacion")
    private String observacion;
	
	@Column(name = "fecha_registro", columnDefinition = "DATE")
	@NotNull
    private LocalDate fecha_registro;
	
	public Inventario_itemEntity(
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
