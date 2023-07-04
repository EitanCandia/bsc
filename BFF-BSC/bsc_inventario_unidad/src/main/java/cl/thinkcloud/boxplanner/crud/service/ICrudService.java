package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.InventarioUnidadDTO;

public interface ICrudService {
    List<InventarioUnidadDTO> findAll();

    Optional<InventarioUnidadDTO> findById(int id);

    InventarioUnidadDTO save(InventarioUnidadDTO inventarioUnidad);

    void delete(int id);
}
