package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ideasDTO;






public interface ServiceBff1 {

	//micro1 Juanito Perez
    public List<ideasDTO> micro1FindAll();
    public Optional<ideasDTO> micro1FindById(int id);
    //public PersonaDTO micro1Save(PersonaDTO persona);
    //public void micro1Delete(int id);
    
    //micro2 Mickey Mouse
    //public List<PersonaDTO> micro2FindAll();
    //public Optional<PersonaDTO> micro2FindById(int id);
    //public PersonaDTO micro2Save(PersonaDTO persona);
    //public void micro2Delete(int id);
    
    //public void customer1();
    //public void customer2();

}
