package com.bsc.rest.service;

import java.util.List;
import java.util.Optional;

import com.bsc.rest.dto.Bsc_temaDTO;
import com.bsc.rest.entity.Bsc_temaEntity;

public interface ICrudService {
    public List<Bsc_temaDTO> findAll();
    public Optional<Bsc_temaDTO> findById(int id);
    public Bsc_temaDTO save(Bsc_temaDTO tema);
    public void delete(int id);
}
