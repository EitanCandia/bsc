package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.ProyectoPersonaDTO;

public interface ICrudService {
    public List<ProyectoPersonaDTO> findAll();
    public Optional<ProyectoPersonaDTO> findById(int id);
    public ProyectoPersonaDTO save(ProyectoPersonaDTO persona);
    public void delete(int id);
}
