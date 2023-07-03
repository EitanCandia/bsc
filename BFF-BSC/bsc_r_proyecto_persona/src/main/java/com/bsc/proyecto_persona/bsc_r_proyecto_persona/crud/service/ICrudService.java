package com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.service;

import java.util.List;
import java.util.Optional;

import com.bsc.proyecto_persona.bsc_r_proyecto_persona.crud.dto.ProyectoPersonaDTO;

public interface ICrudService {
    public List<ProyectoPersonaDTO> findAll();
    public Optional<ProyectoPersonaDTO> findById(int id);
    public ProyectoPersonaDTO save(ProyectoPersonaDTO persona);
    public void delete(int id);
}
