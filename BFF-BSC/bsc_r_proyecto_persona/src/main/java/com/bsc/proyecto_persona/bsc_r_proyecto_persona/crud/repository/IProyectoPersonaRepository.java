package com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.entity.ProyectoPersonaEntity;


@Repository
public interface IProyectoPersonaRepository extends CrudRepository <ProyectoPersonaEntity, Integer> {
}
