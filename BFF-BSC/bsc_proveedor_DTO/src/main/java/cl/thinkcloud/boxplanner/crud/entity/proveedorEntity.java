package cl.thinkcloud.boxplanner.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bsc_proveedor")
public class proveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "organizacion", columnDefinition = "VARCHAR(50)")
    private String organizacion;

    @Column(name = "contacto", columnDefinition = "VARCHAR(50)")
    private String contacto;

    @Column(name = "cargo", columnDefinition = "VARCHAR(50)")
    private String cargo;

    @Column(name = "email", columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "telefono_trabajo", columnDefinition = "VARCHAR(25)")
    private String telefono_trabajo;

    @Column(name = "telefono_movil", columnDefinition = "VARCHAR(25)")
    private String telefono_movil;

    @Column(name = "telefono_personal", columnDefinition = "VARCHAR(25)")
    private String telefono_personal;

    @Column(name = "direccion", columnDefinition = "VARCHAR(100)")
    private String direccion;

    @Column(name = "ciudad", columnDefinition = "VARCHAR(100)")
    private String ciudad;

    @Column(name = "estado_provincia", columnDefinition = "VARCHAR(100)")
    private String estado_provincia;

    @Column(name = "pais_region", columnDefinition = "VARCHAR(50)")
    private String pais_region;

    @Column(name = "codigo_postal", columnDefinition = "VARCHAR(10)")
    private String codigo_postal;

    @Column(name = "pagina_web", columnDefinition = "VARCHAR(100)")
    private String pagina_web;

    @Column(name = "observaciones", columnDefinition = "LONGTEXT")
    private String observaciones;

    @Column(name = "fecha_registro", columnDefinition = "DATE")
    private Date fecha_registro;

    public proveedorEntity(
            @JsonProperty("id") int id,
            @JsonProperty("bscproyectoid") int bscproyectoid,
            @JsonProperty("bscobjetivoid") int bscobjetivoid,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("alias") String alias,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("orden") int orden,
            @JsonProperty("formula") String formula,
            @JsonProperty("fecharegistro") Date fecharegistro,
            @JsonProperty("organizacion") String organizacion,
            @JsonProperty("contacto") String contacto,
            @JsonProperty("cargo") String cargo,
            @JsonProperty("email") String email,
            @JsonProperty("telefono_trabajo") String telefono_trabajo,
            @JsonProperty("telefono_movil") String telefono_movil,
            @JsonProperty("telefono_personal") String telefono_personal,
            @JsonProperty("direccion") String direccion,
            @JsonProperty("ciudad") String ciudad,
            @JsonProperty("estado_provincia") String estado_provincia,
            @JsonProperty("pais_region") String pais_region,
            @JsonProperty("codigo_postal") String codigo_postal,
            @JsonProperty("pagina_web") String pagina_web,
            @JsonProperty("observaciones") String observaciones,
            @JsonProperty("fecha_registro") Date fecha_registro) {

        super();
        this.id = id;
        this.organizacion = organizacion;
        this.contacto = contacto;
        this.cargo = cargo;
        this.email = email;
        this.telefono_trabajo = telefono_trabajo;
        this.telefono_movil = telefono_movil;
        this.telefono_personal = telefono_personal;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado_provincia = estado_provincia;
        this.pais_region = pais_region;
        this.codigo_postal = codigo_postal;
        this.pagina_web = pagina_web;
        this.observaciones = observaciones;
        this.fecha_registro = fecha_registro;
    }
}
