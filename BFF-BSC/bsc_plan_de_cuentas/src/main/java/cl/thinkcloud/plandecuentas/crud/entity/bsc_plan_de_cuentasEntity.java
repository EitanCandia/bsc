package cl.thinkcloud.plandecuentas.crud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name="bsc_plan_de_cuentas")
public class bsc_plan_de_cuentasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "bsc_plan_de_cuentas_id_padre", nullable = false, length = 11)
    private String bscPlanDeCuentasIdPadre;

    @Column(name = "nivel", nullable = false)
    private int nivel;

    @NotBlank
    @Column(name = "codigo", nullable = false, length = 100)
    private String codigo;

    @NotBlank
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "presupuesto_anual_final")
    private Integer presupuestoAnualFinal;

    @Column(name = "presupuesto_anual_original")
    private int presupuestoAnualOriginal;

    @NotBlank
    @Column(name = "observacion", length = 500)
    private String observacion;


    @Column(name = "reasignable")
    private boolean reasignable;

    @NotNull
    @Column(name = "mostrar_en_items", nullable = false)
    private boolean mostrarEnItems;

    @NotNull
    @Column(name = "fecha_registro", columnDefinition = "DATE", nullable = false)
    private Date fechaRegistro;
	
    public bsc_plan_de_cuentasEntity(int id, String bscPlanDeCuentasIdPadre, int nivel, String codigo, String nombre,
                            int presupuestoAnualFinal, int presupuestoAnualOriginal, String observacion,
                            boolean reasignable, boolean mostrarEnItems, Date fechaRegistro) {
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
//{
//    "id": 1,
//    "bscPlanDeCuentasIdPadre": "prueba-pr",
//    "nivel": 1,
//    "codigo": "codigo-cod",
//    "nombre": "nombrenombrenombre",
//    "presupuesto_anual_final": 2,
//    "presupuesto_anual_original": 2,
//    "observacion": "observacion-observacion",
//    "resignable": true,
//    "mostrar_en_items": false,
//    "fechaRegistro": "2003-07-05"
//  }