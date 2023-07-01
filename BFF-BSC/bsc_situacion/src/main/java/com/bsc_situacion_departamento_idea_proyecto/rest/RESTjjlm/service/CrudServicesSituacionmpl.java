package com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.service;

import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.dto.SituacionDTO;
import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.entity.SituacionEntity;
import com.bsc_situacion_departamento_idea_proyecto.rest.RESTjjlm.repository.ISituacionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class CrudServicesSituacionmpl implements ICrudService {
	
	public final Logger logger = LoggerFactory.getLogger(CrudServicesSituacionmpl.class);
	
	@Autowired
	private ISituacionRepository data;
	
	public SituacionEntity situacionDTO2Entity(SituacionDTO sDTO) {
		logger.info("Servicer-situacionDTO2Entity");
		SituacionEntity sENT = new SituacionEntity();
		sENT.setId_bsc_situacion_departamento_idea_proyecto(sDTO.getId_bsc_situacion_departamento_idea_proyecto());
		sENT.setBsc_r_situacion_departamento_id(sDTO.getBsc_r_situacion_departamento_id());
		sENT.setBsc_idea_id(sDTO.getBsc_idea_id());
		sENT.setBsc_proyecto_id(sDTO.getBsc_proyecto_id());
		sENT.setCantidad_votos(sDTO.getCantidad_votos());
		sENT.setIncluir(sDTO.isIncluir());
		sENT.setFecha_registro(sDTO.getFecha_registro());
		return sENT;		
	}
		
	public SituacionDTO situacionEntity2DTO(SituacionEntity sENT) {
		logger.info("Servicer-situacionEntity2DTO");
		SituacionDTO sDTO = new SituacionDTO();
		sDTO.setId_bsc_situacion_departamento_idea_proyecto(sENT.getId_bsc_situacion_departamento_idea_proyecto());
		sDTO.setBsc_r_situacion_departamento_id(sENT.getBsc_r_situacion_departamento_id());
		sDTO.setBsc_idea_id(sENT.getBsc_idea_id());
		sDTO.setBsc_proyecto_id(sENT.getBsc_proyecto_id());
		sDTO.setCantidad_votos(sENT.getCantidad_votos());
		sDTO.setIncluir(sENT.isIncluir());
		sDTO.setFecha_registro(sENT.getFecha_registro());
		return sDTO;	
	}
	
	@Override
	public List<SituacionDTO> findAll(){
		List<SituacionDTO> lsDTO = new ArrayList<SituacionDTO>();
		
		Iterable <SituacionEntity> itSE = data.findAll();
		Iterator <SituacionEntity> it = itSE.iterator();
		
		while (it.hasNext()) {
			SituacionEntity sE = it.next();
			SituacionDTO sDTO = situacionEntity2DTO(sE);
			lsDTO.add(sDTO);
		}
		
		return lsDTO;
	}
	
	@Override
	public Optional<SituacionDTO> findById(int id){
		Optional<SituacionEntity> oSE = data.findById(id);
		SituacionEntity sE = oSE.get();
		SituacionDTO sDTO = situacionEntity2DTO(sE);
		
		Optional<SituacionDTO> osDTO = Optional.ofNullable(sDTO);
		
		return osDTO;
		
	}
	
	@Override
	public SituacionDTO save(SituacionDTO s) {
		SituacionEntity sE = situacionDTO2Entity(s);
		data.save(sE);
		
		return s;
	}
	
	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}

