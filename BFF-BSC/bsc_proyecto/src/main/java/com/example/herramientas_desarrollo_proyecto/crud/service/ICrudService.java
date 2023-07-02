package com.example.herramientas_desarrollo_proyecto.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.herramientas_desarrollo_proyecto.crud.dto.ProyectoDTO;
import com.example.herramientas_desarrollo_proyecto.crud.entity.ProyectoEntity;

public interface ICrudService {
    public List<ProyectoDTO> findAll();
    public Optional<ProyectoDTO> findById(int id);
    public ProyectoDTO save(ProyectoDTO proyecto);
    public void delete(int id);   
}
