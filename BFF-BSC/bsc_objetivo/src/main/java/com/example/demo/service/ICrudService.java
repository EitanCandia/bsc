package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ObjetivoDTO;

public interface ICrudService {

    public List<ObjetivoDTO> findAll();
    public Optional<ObjetivoDTO> findById(int id);
    public ObjetivoDTO save(ObjetivoDTO objetivo);
    public void delete(int id);
	
}
