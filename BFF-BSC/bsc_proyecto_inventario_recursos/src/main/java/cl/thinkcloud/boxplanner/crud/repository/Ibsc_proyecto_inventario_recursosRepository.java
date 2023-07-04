package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.bsc_proyecto_inventario_recursos_Entity;


@Repository
public interface Ibsc_proyecto_inventario_recursosRepository extends CrudRepository <bsc_proyecto_inventario_recursos_Entity, Integer> {
}
