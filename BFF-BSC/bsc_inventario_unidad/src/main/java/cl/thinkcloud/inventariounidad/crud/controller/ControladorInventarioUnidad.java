package cl.thinkcloud.inventariounidad.crud.controller;

import cl.thinkcloud.inventariounidad.crud.dto.InventarioUnidadDTO;
import cl.thinkcloud.inventariounidad.crud.service.ICrudService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/v1/org/inventario-unidad")
public class ControladorInventarioUnidad {

    public final Logger logger = LoggerFactory.getLogger(ControladorInventarioUnidad.class);

    @Autowired
    private ICrudService servicio;

    @ResponseBody
    @PostMapping("REST") // CREATE-POST
    public InventarioUnidadDTO agregarInventarioUnidad(
            @Valid @NonNull @RequestBody InventarioUnidadDTO inventarioUnidad) {
        logger.info("Controlador-agregarInventarioUnidad");
        return servicio.save(inventarioUnidad);
    }

    @ResponseBody
    @GetMapping("REST") // READ-GET
    public List<InventarioUnidadDTO> getAllInventarioUnidades() {
        logger.info("Controlador-getAllInventarioUnidades");
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("REST/{id}") // READ-GET/id
    public InventarioUnidadDTO getInventarioUnidad(@PathVariable("id") int id) {
        InventarioUnidadDTO inventarioUnidadDTO = servicio.findById(id).orElse(null);
        return inventarioUnidadDTO;
    }

    @ResponseBody
    @PutMapping(("REST")) // UPDATE-PUT
    public InventarioUnidadDTO updateInventarioUnidad(
            @Valid @NonNull @RequestBody InventarioUnidadDTO inventarioUnidad) {
        Optional<InventarioUnidadDTO> optionalInventarioUnidad = servicio.findById(inventarioUnidad.getId());
        if (optionalInventarioUnidad.isPresent()) {
            return servicio.save(inventarioUnidad);
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping(("REST/{id}")) // UPDATE-PUT
    public InventarioUnidadDTO updateInventarioUnidadById(
            @Valid @NonNull @RequestBody InventarioUnidadDTO inventarioUnidad,
            @PathVariable("id") int id) {
        Optional<InventarioUnidadDTO> optionalInventarioUnidad = servicio.findById(id);
        if (optionalInventarioUnidad.isPresent()) {
            inventarioUnidad.setId(id);
            return servicio.save(inventarioUnidad);
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("REST") // DELETE-DELETE
    public InventarioUnidadDTO deleteInventarioUnidad(
            @Valid @NonNull @RequestBody InventarioUnidadDTO inventarioUnidad) {
        Optional<InventarioUnidadDTO> optionalInventarioUnidad = servicio.findById(inventarioUnidad.getId());
        if (optionalInventarioUnidad.isPresent()) {
            servicio.delete(inventarioUnidad.getId());
            return inventarioUnidad;
        } else {
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("REST/{id}") // DELETE-DELETE
    public int deleteInventarioUnidadById(@PathVariable("id") int id) {
        Optional<InventarioUnidadDTO> optionalInventarioUnidad = servicio.findById(id);
        if (optionalInventarioUnidad.isPresent()) {
            servicio.delete(id);
            return 1;
        } else {
            return 0;
        }
    }
}
