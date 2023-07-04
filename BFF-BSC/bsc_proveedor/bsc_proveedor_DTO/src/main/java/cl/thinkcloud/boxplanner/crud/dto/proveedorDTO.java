package cl.thinkcloud.boxplanner.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import java.util.Date;

@Data
@NoArgsConstructor
public class proveedorDTO {

    private int id;

    @NotNull
    private String organizacion;
    private String contacto;
    private String cargo;
    private String email;
    private String telefono_trabajo;
    private String telefono_movil;
    private String telefono_personal;
    private String direccion;
    private String ciudad;
    private String estado_provincia;
    private String pais_region;
    private String codigo_postal;
    private String pagina_web;
    private String observaciones;
    private Date fecha_registro;

    public proveedorDTO(
            @JsonProperty("id") int id,
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
