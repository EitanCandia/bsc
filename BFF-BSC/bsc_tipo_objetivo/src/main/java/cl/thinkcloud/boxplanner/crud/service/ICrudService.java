package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.bsc_tipo_objetivoDTO;



public interface ICrudService {
    public List<bsc_tipo_objetivoDTO> findAll();
    public Optional<bsc_tipo_objetivoDTO> findById(int id);
    public bsc_tipo_objetivoDTO save(bsc_tipo_objetivoDTO persona);
    public void delete(int id);
}