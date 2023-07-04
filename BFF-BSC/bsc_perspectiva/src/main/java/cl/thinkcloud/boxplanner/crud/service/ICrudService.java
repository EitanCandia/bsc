package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.Bsc_perspectivaDTO;



public interface ICrudService {
    public List<Bsc_perspectivaDTO> findAll();
    public Optional<Bsc_perspectivaDTO> findById(int id);
    public Bsc_perspectivaDTO save(Bsc_perspectivaDTO persona);
    public void delete(int id);
}