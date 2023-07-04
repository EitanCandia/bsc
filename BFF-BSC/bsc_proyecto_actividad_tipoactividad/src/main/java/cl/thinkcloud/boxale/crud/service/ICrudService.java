package cl.thinkcloud.boxale.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxale.crud.dto.ProyectoDTO;
import cl.thinkcloud.boxale.crud.entity.bsc_proyecto_actividadEntity;

public interface ICrudService {
    public List<ProyectoDTO> findAll();
    public Optional<ProyectoDTO> findById(int id);
    public ProyectoDTO save(ProyectoDTO proyecto);
    public void delete(int id);
}
