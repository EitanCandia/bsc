package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.restclients.proveedorMicro1;
import com.example.demo.dto.proveedorDTO;

@Service
public class proveedorServiceBff1Impl implements proveedorServiceBff1 {


    @Autowired
    proveedorMicro1 micro1;

    @Override
    public List<proveedorDTO> proveedorFindAll() {
        // TODO Auto-generated method stub
        return micro1.findAll();
    }

    @Override
    public Optional<proveedorDTO> proveedorFindById(int id) {
        // TODO Auto-generated method stub
        return micro1.findById(id);
    }

    @Override
    public proveedorDTO proveedorSave(proveedorDTO proveedor) {
        // TODO Auto-generated method stub
        return micro1.proveedorSave(proveedor);
    }

    @Override
    public void proveedordelete(int id) {
        micro1.proveedordelete(id);
    }

    @Override
    public proveedorDTO proveedorUpdate(int id, proveedorDTO proveedor) {
        // TODO Auto-generated method stub
        return micro1.proveedorUpdate(id, proveedor);
    }

}