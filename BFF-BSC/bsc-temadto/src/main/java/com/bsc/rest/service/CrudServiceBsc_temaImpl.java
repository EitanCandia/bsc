package com.bsc.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bsc.rest.dto.Bsc_temaDTO;
import com.bsc.rest.entity.Bsc_temaEntity;
import com.bsc.rest.repository.IBsc_temaRepository;

@Component
@Service
public class CrudServiceBsc_temaImpl implements ICrudService {
	
	public final Logger logger = LoggerFactory.getLogger(CrudServiceBsc_temaImpl.class);
	 @Autowired
	    private IBsc_temaRepository data;
	 
	 public Bsc_temaEntity Bsc_temaDTO2Entity(Bsc_temaDTO bsctemadto) {
		 logger.info("Servicer-Bsc_temaDTO2Entity");
		 
		 Bsc_temaEntity bsc_temadto = new Bsc_temaEntity();
		 bsc_temadto.setId(bsctemadto.getId());
		 bsc_temadto.setBsc_perspectiva_id(bsctemadto.getBsc_perspectiva_id());
		 bsc_temadto.setNombre(bsctemadto.getNombre()); 
		 bsc_temadto.setAlias(bsctemadto.getAlias());
		 bsc_temadto.setDescripcion(bsctemadto.getDescripcion());
		 bsc_temadto.setOrden(bsctemadto.getOrden());
		 bsc_temadto.setFecha_registro(bsctemadto.getFecha_registro());
		 
		return bsc_temadto;
		 
	 }
	 
	 public Bsc_temaDTO Bsc_temaEntity2DTO(Bsc_temaEntity bsctemaentity) {
		 logger.info("Servicer-Bsc_temaEntity2DTO");
		 
		 Bsc_temaDTO bsctemaDto = new Bsc_temaDTO();
		 bsctemaDto.setId(bsctemaentity.getId());
		 bsctemaDto.setBsc_perspectiva_id(bsctemaentity.getBsc_perspectiva_id());
		 bsctemaDto.setNombre(bsctemaentity.getNombre()); 
		 bsctemaDto.setAlias(bsctemaentity.getAlias());
		 bsctemaDto.setDescripcion(bsctemaentity.getDescripcion());
		 bsctemaDto.setOrden(bsctemaentity.getOrden());
		 bsctemaDto.setFecha_registro(bsctemaentity.getFecha_registro());
		 
		 
		 
		 return bsctemaDto;
	 }

	@Override
	public List<Bsc_temaDTO> findAll() {
		// TODO Auto-generated method stub
		
		List<Bsc_temaDTO> lbsctemadto = new ArrayList<Bsc_temaDTO>();
		Iterable<Bsc_temaEntity> itbsctema = data.findAll();
		Iterator<Bsc_temaEntity> it = itbsctema.iterator();
		
		while (it.hasNext())
    	{
			Bsc_temaEntity btemaEntity = it.next();
			Bsc_temaDTO btDTO = Bsc_temaEntity2DTO(btemaEntity);
    		lbsctemadto.add(btDTO);
    	}
    	
        return lbsctemadto;
	}

	@Override
	public Optional<Bsc_temaDTO> findById(int id) {
		// TODO Auto-generated method stub
		Optional<Bsc_temaEntity> obtE = data.findById(id);
		
		Bsc_temaEntity btE = obtE.get();
		Bsc_temaDTO btDTO = Bsc_temaEntity2DTO(btE);
		Optional<Bsc_temaDTO> obtDTO = Optional.ofNullable(btDTO);
		
		return obtDTO;
	}

	@Override
	public Bsc_temaDTO save(Bsc_temaDTO bsc_temaDTO ) {
		Bsc_temaEntity bsc_temaentity = Bsc_temaDTO2Entity(bsc_temaDTO);
		data.save(bsc_temaentity);
	    return bsc_temaDTO;
	}

	@Override
	public void delete(int id) {
		 data.deleteById(id);
		
	}

}
