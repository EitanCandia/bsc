package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.ideasDTO;

public interface ICrudService {
    public List<ideasDTO> findAll();
    public Optional<ideasDTO> findById(int id);
    public ideasDTO save(ideasDTO persona);
    public void delete(int id);
}
