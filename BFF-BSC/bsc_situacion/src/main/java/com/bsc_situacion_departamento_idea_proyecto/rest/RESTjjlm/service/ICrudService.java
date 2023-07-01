package com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.service;

import java.util.List;
import java.util.Optional;

import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.dto.SituacionDTO;

public interface ICrudService {
    public List<SituacionDTO> findAll();
    public Optional<SituacionDTO> findById(int id);
    public SituacionDTO save(SituacionDTO situacion);
    public void delete(int id);
}

