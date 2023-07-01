package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LugarDTO;
import com.example.demo.entity.LugarEntity;
import com.example.demo.repository.LugarRepository;

@Component
@Service
public class CrudLugarImpl implements ICrudService{

	public final Logger logger = LoggerFactory.getLogger(CrudLugarImpl.class);
	
	@Autowired
	private LugarRepository data;
	
	public LugarEntity lugarDTO2Entity(LugarDTO lDTO) {
		
		logger.info("Service-lugarDTO2Entity");
		
		LugarEntity lEntity = new LugarEntity();
		lEntity.setId(lDTO.getId());
		lEntity.setBsc_lugar_id_padre(lDTO.getBsc_lugar_id_padre());
		lEntity.setNivel(lDTO.getNivel());
		lEntity.setLugar(lDTO.getLugar());
		lEntity.setEdificio(lDTO.getEdificio());
		lEntity.setArea(lDTO.getArea());
		lEntity.setPiso(lDTO.getPiso());
		lEntity.setSubarea(lDTO.getSubarea());
		lEntity.setFecha_registro(lDTO.getFecha_registro());
		return lEntity;
	}
	
	public LugarDTO lugarEntity2DTO(LugarEntity lE) {
		
		logger.info("Service-lugarEntity2DTO");
		
		LugarDTO lDTO = new LugarDTO();
		lDTO.setId(lE.getId());
		lDTO.setBsc_lugar_id_padre(lE.getBsc_lugar_id_padre());
		lDTO.setNivel(lE.getNivel());
		lDTO.setLugar(lE.getLugar());
		lDTO.setEdificio(lE.getEdificio());
		lDTO.setArea(lE.getArea());
		lDTO.setPiso(lE.getPiso());
		lDTO.setSubarea(lE.getSubarea());
		lDTO.setFecha_registro(lE.getFecha_registro());
		
		return lDTO;
	}
	
	
	@Override
	public List<LugarDTO> findAll(){
		
		List<LugarDTO> llDTO = new ArrayList<LugarDTO>();
		Iterable<LugarEntity> itLE = data.findAll();
		Iterator<LugarEntity> it = itLE.iterator();
		
		while (it.hasNext()) {
			LugarEntity lE = it.next();
			LugarDTO lDTO = lugarEntity2DTO(lE);
			llDTO.add(lDTO);
		}
		
		return llDTO;
	}
	
	@Override
	public Optional<LugarDTO> findById(int id){
		
		Optional<LugarEntity> oLE = data.findById(id);
		LugarEntity lE = oLE.get();
		LugarDTO lDTO = lugarEntity2DTO(lE);
		
		Optional<LugarDTO> olDTO = Optional.ofNullable(lDTO);
		
		return olDTO;
	}
	
	@Override
	public LugarDTO save(LugarDTO l) {
		LugarEntity lE = lugarDTO2Entity(l);
		data.save(lE);
		return l;
	}
	
	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
