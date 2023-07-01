package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import com.example.demo.crud.dto.DTOBscProyectoPedido;
//import com.example.demo.entity.EntityBscProyectoPedido;

public interface ICrudService {
	public List<DTOBscProyectoPedido> findAll();
    public Optional<DTOBscProyectoPedido> findById(int id);
    public DTOBscProyectoPedido save(DTOBscProyectoPedido bpp);
    public void delete(int id);
	
	
}
