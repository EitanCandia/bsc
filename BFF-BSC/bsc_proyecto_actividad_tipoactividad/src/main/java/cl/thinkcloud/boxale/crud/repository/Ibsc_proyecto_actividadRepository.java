package cl.thinkcloud.boxale.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxale.crud.entity.bsc_proyecto_actividadEntity;


@Repository
public interface Ibsc_proyecto_actividadRepository extends CrudRepository <bsc_proyecto_actividadEntity, Integer> {
}

