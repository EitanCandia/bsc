package com.tomas.msr.service;

import java.util.List;
import java.util.Optional;

import com.tomas.msr.dto.Proyecto_ActividadDTO;
import com.tomas.msr.entity.Proyecto_ActividadEntity;

public interface ICrudService {
	  	public List<Proyecto_ActividadDTO> findAll();
	    public Optional<Proyecto_ActividadDTO> findById(int id);
	    public Proyecto_ActividadDTO save(Proyecto_ActividadDTO proyecto_actividad);
	    public void delete(int id);
}
