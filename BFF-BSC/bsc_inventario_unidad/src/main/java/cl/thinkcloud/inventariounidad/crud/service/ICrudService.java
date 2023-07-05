package cl.thinkcloud.inventariounidad.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.inventariounidad.crud.dto.InventarioUnidadDTO;

public interface ICrudService {
    List<InventarioUnidadDTO> findAll();

    Optional<InventarioUnidadDTO> findById(int id);

    InventarioUnidadDTO save(InventarioUnidadDTO inventarioUnidad);

    void delete(int id);
}
