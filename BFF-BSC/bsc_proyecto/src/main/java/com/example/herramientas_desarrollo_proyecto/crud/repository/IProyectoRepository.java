package com.example.herramientas_desarrollo_proyecto.crud.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.herramientas_desarrollo_proyecto.crud.entity.ProyectoEntity;


@Repository
public interface IProyectoRepository extends CrudRepository <ProyectoEntity, Integer> {
    
}
