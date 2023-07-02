package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.ProyectoPersonaDTO;
import cl.thinkcloud.boxplanner.crud.entity.ProyectoPersonaEntity;
import cl.thinkcloud.boxplanner.crud.repository.IProyectoPersonaRepository;

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
public class CrudServiceProyectoPersonaImpl implements ICrudService {

	public final Logger logger = LoggerFactory.getLogger(CrudServiceProyectoPersonaImpl.class);
	
    @Autowired
    private IProyectoPersonaRepository data;

    public ProyectoPersonaEntity proyectoPersonaDTO2Entity(ProyectoPersonaDTO ppDTO) {
    	logger.info("Service-proyectoPersonaDTO2Entity");
    	ProyectoPersonaEntity ppEntity = new ProyectoPersonaEntity();
    	ppEntity.setBscProyectoId(ppDTO.getBscProyectoId());
    	ppEntity.setOrgPersonaId(ppDTO.getOrgPersonaId());
    	ppEntity.setFechaRegistro(ppDTO.getFechaRegistro());
    	return ppEntity;
    }
    
    public ProyectoPersonaDTO proyectoPersonaEntity2DTO(ProyectoPersonaEntity ppE) {
    	logger.info("Service-proyectoPersonaEntity2DTO");
    	ProyectoPersonaDTO ppDTO = new ProyectoPersonaDTO();
    	ppDTO.setBscProyectoId(ppE.getBscProyectoId());
    	ppDTO.setOrgPersonaId(ppE.getOrgPersonaId());
    	ppDTO.setFechaRegistro(ppE.getFechaRegistro());
    	return ppDTO;
    }
    
    @Override
    public List<ProyectoPersonaDTO> findAll() {
    	List<ProyectoPersonaDTO> lppDTO = new ArrayList<ProyectoPersonaDTO>();
    	
    	Iterable<ProyectoPersonaEntity> itPPE = data.findAll();
    	
    	Iterator<ProyectoPersonaEntity> it = itPPE.iterator();
    	
    	while (it.hasNext()) {
    		ProyectoPersonaEntity ppE = it.next();
    		ProyectoPersonaDTO ppDTO = proyectoPersonaEntity2DTO(ppE);
    		lppDTO.add(ppDTO);
    	}
    	
        return lppDTO;
    }

    @Override
    public Optional<ProyectoPersonaDTO> findById(int id) {
    	Optional<ProyectoPersonaEntity> oPPE = data.findById(id);
    	
    	if (oPPE.isPresent()) {
    		ProyectoPersonaEntity ppE = oPPE.get();
    		
    		ProyectoPersonaDTO ppDTO = proyectoPersonaEntity2DTO(ppE);
        
    		Optional<ProyectoPersonaDTO> oppDTO = Optional.ofNullable(ppDTO);
        	
    		return oppDTO;
    	} else {		
            return Optional.empty();    		
    	}
    }

    @Override
    public ProyectoPersonaDTO save(ProyectoPersonaDTO pp) {
    	ProyectoPersonaEntity ppE = proyectoPersonaDTO2Entity(pp);
        ppE = data.save(ppE);
        ProyectoPersonaDTO ppDTO = this.proyectoPersonaEntity2DTO(ppE);
        return ppDTO;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
}
