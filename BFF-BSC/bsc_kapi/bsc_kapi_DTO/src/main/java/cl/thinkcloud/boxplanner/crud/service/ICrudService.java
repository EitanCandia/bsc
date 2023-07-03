package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.boxplanner.crud.dto.kapi_final_DTO;

public interface ICrudService {
    public List<kapi_final_DTO> findAll();
    public Optional<kapi_final_DTO> findById(int id);
    public kapi_final_DTO save(kapi_final_DTO kapi);
    public void delete(int id);
}
