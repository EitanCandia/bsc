package com.example.demo.service;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ObjetivoDTO;
import com.example.demo.entity.ObjetivoEntity;
import com.example.demo.repository.IObjetivoRepository;


@Component
@Service
public class CrudServiceObjetivoImpl implements ICrudService {
	
	public final Logger logger = LoggerFactory.getLogger(CrudServiceObjetivoImpl.class);


    @Autowired
    private IObjetivoRepository data;

    public ObjetivoEntity objetivoDTO2Entity(ObjetivoDTO pDTO)
    {
    	logger.info("Service-objetivoDTO2Entity");

    	ObjetivoEntity pEntity = new ObjetivoEntity();
    	pEntity.setId(pDTO.getId());
    	pEntity.setNombre(pDTO.getNombre());
    	pEntity.setAlias(pDTO.getAlias());
    	pEntity.setDescripcion(pDTO.getDescripcion());
    	pEntity.setOrden(pDTO.getOrden());
    	pEntity.setCodigo(pDTO.getCodigo());
    	pEntity.setFecha_registro(pDTO.getFecha_registro());
    	pEntity.setBsc_tema_id(pDTO.getBsc_tema_id());
    	pEntity.setBsc_tipo_objetivo_id(pDTO.getBsc_tipo_objetivo_id());
    	pEntity.setOrg_departamento_id_responsable(pDTO.getOrg_departamento_id_responsable());
 
    	return pEntity;
    }
    
    public ObjetivoDTO objetivoEntity2DTO(ObjetivoEntity pE) 
    {
    	logger.info("Service-objetivoEntity2DTO");

    	ObjetivoDTO pDTO = new ObjetivoDTO();
    	pDTO.setId(pE.getId());
    	pDTO.setNombre(pE.getNombre());
    	pDTO.setAlias(pE.getAlias());
    	pDTO.setDescripcion(pE.getDescripcion());
    	pDTO.setOrden(pE.getOrden());
    	pDTO.setCodigo(pE.getCodigo());
    	pDTO.setFecha_registro(pE.getFecha_registro());
    	pDTO.setBsc_tema_id(pE.getBsc_tema_id());
    	pDTO.setBsc_tipo_objetivo_id(pE.getBsc_tipo_objetivo_id());
    	pDTO.setOrg_departamento_id_responsable(pE.getOrg_departamento_id_responsable());
    	return pDTO;
    }
    
    @Override
    public List<ObjetivoDTO> findAll() {
    	
    	List<ObjetivoDTO> lpDTO = new ArrayList<ObjetivoDTO>();
    	
    	Iterable<ObjetivoEntity> itPE = data.findAll();
    	
    	Iterator<ObjetivoEntity> it = itPE.iterator();
    	
    	while (it.hasNext())
    	{
    		ObjetivoEntity pE = it.next();
    		ObjetivoDTO pDTO = objetivoEntity2DTO(pE);
    		lpDTO.add(pDTO);
    	}
    	
    	return lpDTO;
    	
    }

    @Override
    public Optional<ObjetivoDTO> findById(int id) {
    	
    	Optional<ObjetivoEntity> oPE = data.findById(id);
    	
    	ObjetivoEntity pE = oPE.get();
    	ObjetivoDTO pDTO = objetivoEntity2DTO(pE);
    	
    	Optional<ObjetivoDTO> opDTO = Optional.ofNullable(pDTO);

        return opDTO;
    }

    @Override
    public ObjetivoDTO save(ObjetivoDTO p) {
    	
    	ObjetivoEntity pE = objetivoDTO2Entity(p);
    	
    	data.save(pE);
        
    	return p;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
    

}
