package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.proveedorDTO;

public interface ICrudService {
    public List<proveedorDTO> findAll();
    public Optional<proveedorDTO> findById(int id);
    public proveedorDTO save(proveedorDTO kpiMeta);
    public void delete(int id);
}
