package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.kapi_final_DTO;





public interface kapiServiceBff1 {

	//micro1 Juanito Perez
    public List<kapi_final_DTO> micro1FindAll();
    public Optional<kapi_final_DTO> micro1FindById(int id);
    public kapi_final_DTO kapisave(kapi_final_DTO kapi);
    public void kapidelete(int id);
    public kapi_final_DTO kapiupdate(int id, kapi_final_DTO kapi);
}
