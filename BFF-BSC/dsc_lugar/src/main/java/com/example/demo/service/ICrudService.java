package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.LugarDTO;

public interface ICrudService {
	public List<LugarDTO> findAll();
	public Optional<LugarDTO> findById(int id);
	public LugarDTO save(LugarDTO lugar);
	public void delete(int id);
}
