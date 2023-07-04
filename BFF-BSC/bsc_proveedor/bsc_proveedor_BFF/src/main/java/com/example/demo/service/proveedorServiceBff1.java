package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.proveedorDTO;





public interface proveedorServiceBff1 {

    
    public List<proveedorDTO> proveedorFindAll();
    public Optional<proveedorDTO> proveedorFindById(int id);
    public proveedorDTO proveedorSave(proveedorDTO proveedor);
    public void proveedordelete(int id);
    public proveedorDTO proveedorUpdate(int id, proveedorDTO proveedor);

}
