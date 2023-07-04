package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.entity.bsc_proyecto_inventario_recursos_Entity;

public interface ICrudService {
    public List<bsc_proyecto_inventario_recursos_Entity> findAll();
    public Optional<bsc_proyecto_inventario_recursos_Entity> findById(int id);
    public bsc_proyecto_inventario_recursos_Entity save(bsc_proyecto_inventario_recursos_Entity bsc_proyecto_inventario_recursos);
    public void delete(int id);
}
