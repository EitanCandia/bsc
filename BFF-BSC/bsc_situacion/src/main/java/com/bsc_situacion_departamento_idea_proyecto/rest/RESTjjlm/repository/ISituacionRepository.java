package com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.entity.SituacionEntity;

@Repository
public interface ISituacionRepository extends CrudRepository <SituacionEntity, Integer> {
}
