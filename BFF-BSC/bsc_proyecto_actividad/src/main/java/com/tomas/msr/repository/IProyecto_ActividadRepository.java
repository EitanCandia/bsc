package com.tomas.msr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tomas.msr.entity.Proyecto_ActividadEntity;

@Repository
public interface IProyecto_ActividadRepository extends CrudRepository<Proyecto_ActividadEntity, Integer> {

}
