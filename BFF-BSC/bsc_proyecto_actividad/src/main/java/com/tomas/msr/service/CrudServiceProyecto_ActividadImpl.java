package com.tomas.msr.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tomas.msr.dto.Proyecto_ActividadDTO;
import com.tomas.msr.entity.Proyecto_ActividadEntity;
import com.tomas.msr.repository.IProyecto_ActividadRepository;

@Component
@Service
public class CrudServiceProyecto_ActividadImpl implements ICrudService {

	public final Logger logger = LoggerFactory.getLogger(CrudServiceProyecto_ActividadImpl.class);
	
    @Autowired
    private IProyecto_ActividadRepository data;
    
    public Proyecto_ActividadEntity proyecto_ActividadDTO2Entity(Proyecto_ActividadDTO paDTO)
    {
    	
    	logger.info("Servicer-proyecto_ActividadDTO2Entity");
    	Proyecto_ActividadEntity paEntity = new Proyecto_ActividadEntity();
    	paEntity.setId(paDTO.getId());
    	paEntity.setBsc_proyecto_objetivo_especifico_id(paDTO.getBsc_proyecto_objetivo_especifico_id());
    	paEntity.setOrg_persona_id_registrador_por(paDTO.getOrg_persona_id_registrador_por());
    	paEntity.setOrg_persona_id_responsable(paDTO.getOrg_persona_id_responsable());
    	paEntity.setCol_pdca_id(paDTO.getCol_pdca_id());
    	paEntity.setBsc_proyecto_actividad_tipoactividad_id(paDTO.getBsc_proyecto_actividad_tipoactividad_id());
    	paEntity.setOrg_ambito_id(paDTO.getOrg_ambito_id());
    	paEntity.setOrg_centro_costo_id(paDTO.getOrg_centro_costo_id());
    	paEntity.setBsc_lugar_id(paDTO.getBsc_lugar_id());
    	paEntity.setNombre(paDTO.getNombre());
    	paEntity.setDescripcion(paDTO.getDescripcion());
     	paEntity.setFecha_registro(paDTO.getFecha_registro());
     	paEntity.setFecha_inicio(paDTO.getFecha_inicio());
    	paEntity.setFecha_termino(paDTO.getFecha_termino());
    	paEntity.setIncluir_en_pao(paDTO.isIncluir_en_pao());
    	paEntity.setPorcentaje_completado(paDTO.getPorcentaje_completado());
    	paEntity.setObservacion_control_gestion(paDTO.getObservacion_control_gestion());
    	return paEntity;
    }
    
    public Proyecto_ActividadDTO proyecto_ActividadEntity2DTO(Proyecto_ActividadEntity paE) 
    {
     	logger.info("Servicer-proyecto_ActividadEntity2DTO");
    	Proyecto_ActividadDTO paDTO = new Proyecto_ActividadDTO();
    	paDTO.setId(paE.getId());
      	paDTO.setBsc_proyecto_objetivo_especifico_id(paE.getBsc_proyecto_objetivo_especifico_id());
      	paDTO.setOrg_persona_id_registrador_por(paE.getOrg_persona_id_registrador_por());
      	paDTO.setOrg_persona_id_responsable(paE.getOrg_persona_id_responsable());
      	paDTO.setCol_pdca_id(paE.getCol_pdca_id());
      	paDTO.setBsc_proyecto_actividad_tipoactividad_id(paE.getBsc_proyecto_actividad_tipoactividad_id());
      	paDTO.setOrg_ambito_id(paE.getOrg_ambito_id());
      	paDTO.setOrg_centro_costo_id(paE.getOrg_centro_costo_id());
      	paDTO.setBsc_lugar_id(paE.getBsc_lugar_id());
      	paDTO.setNombre(paE.getNombre());
      	paDTO.setDescripcion(paE.getDescripcion());
      	paDTO.setFecha_registro(paE.getFecha_registro());
      	paDTO.setFecha_inicio(paE.getFecha_inicio());
      	paDTO.setFecha_termino(paE.getFecha_termino());
      	paDTO.setIncluir_en_pao(paE.isIncluir_en_pao());
      	paDTO.setPorcentaje_completado(paE.getPorcentaje_completado());
      	paDTO.setObservacion_control_gestion(paE.getObservacion_control_gestion());
    	return paDTO;
    }
    
	@Override
	public List<Proyecto_ActividadDTO> findAll() {
		
		logger.info("Servicer-list-findall");
		List<Proyecto_ActividadDTO> lpaDTO = new ArrayList<Proyecto_ActividadDTO>();
		
		Iterable<Proyecto_ActividadEntity> itPAE = data.findAll();
		Iterator<Proyecto_ActividadEntity> it =  itPAE.iterator();
		
		while (it.hasNext()) 
		{
			Proyecto_ActividadEntity paE = it.next();
			
			Proyecto_ActividadDTO paDTO = proyecto_ActividadEntity2DTO(paE);
			lpaDTO.add(paDTO);
		}
		 return lpaDTO;
	}

	@Override
	public Optional<Proyecto_ActividadDTO> findById(int id) {
		 logger.info("Servicer-optional-findbyid");
	     Optional<Proyecto_ActividadEntity> oPAE = data.findById(id);
	     
	     Proyecto_ActividadEntity paE = oPAE.get();
	     
	     Proyecto_ActividadDTO paDTO = proyecto_ActividadEntity2DTO(paE);
	     
	     Optional<Proyecto_ActividadDTO> opDTO = Optional.ofNullable(paDTO);	 
	     return opDTO;
	}

	@Override
	public Proyecto_ActividadDTO save(Proyecto_ActividadDTO proyecto_actividad) {
		 logger.info("Servicer-save");
		Proyecto_ActividadEntity paE= proyecto_ActividadDTO2Entity(proyecto_actividad);
		data.save(paE);
		return proyecto_actividad;
	}

	@Override
	public void delete(int id) {
		 logger.info("Servicer-deletebyid");
	       data.deleteById(id);
		
	}

}