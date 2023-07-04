package cl.thinkcloud.boxale.crud.service;
import cl.thinkcloud.boxale.crud.dto.ProyectoDTO;
import cl.thinkcloud.boxale.crud.entity.bsc_proyecto_actividadEntity;
import cl.thinkcloud.boxale.crud.repository.Ibsc_proyecto_actividadRepository;

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
public class CrudServicebsc_proyecto_actividad implements ICrudService {
	
	
		public final Logger logger = LoggerFactory.getLogger(CrudServicebsc_proyecto_actividad.class);
	
	
		@Autowired
	    private Ibsc_proyecto_actividadRepository data;

	    public bsc_proyecto_actividadEntity proyectoDTO2Entity(ProyectoDTO pDTO)
	    {
	    	logger.info("Servicer-ProyectoDTO2Entity");
	    	bsc_proyecto_actividadEntity pEntity = new bsc_proyecto_actividadEntity();
	    	pEntity.setId(pDTO.getId());
	    	pEntity.setNombre(pDTO.getNombre());
	    	pEntity.setNivel(pDTO.getNivel());
	    	pEntity.setAlias(pDTO.getAlias());
	    	pEntity.setDescripcion(pDTO.getDescripcion());
	    	pEntity.setOrden(pDTO.getOrden());
	    	pEntity.setFecha_registro(pDTO.getFecha_registro());
	    	return pEntity;
	    }
		
	    
	    public ProyectoDTO ProyectoEntity2DTO(bsc_proyecto_actividadEntity pE)
	    {
	    	logger.info("Servicer-ProyectoEntity2DTO");
	    	ProyectoDTO pDTO = new ProyectoDTO();
	    	pDTO.setId(pE.getId());
	    	pDTO.setNombre(pE.getNombre());
	    	pDTO.setId(pE.getId());
	    	pDTO.setNombre(pE.getNombre());
	    	pDTO.setNivel(pE.getNivel());
	    	pDTO.setAlias(pE.getAlias());
	    	pDTO.setDescripcion(pE.getDescripcion());
	    	pDTO.setOrden(pE.getOrden());
	    	pDTO.setFecha_registro(pE.getFecha_registro());
	    	return pDTO;
	    }
	    
	    @Override
	    public List<ProyectoDTO> findAll() {
	    	List<ProyectoDTO> lpDTO = new ArrayList<ProyectoDTO>();
	    	
	    	Iterable<bsc_proyecto_actividadEntity> itPE = data.findAll();
	    	
	    	Iterator<bsc_proyecto_actividadEntity> it = itPE.iterator();
	    	
	    	while (it.hasNext())
	    	{
	    		bsc_proyecto_actividadEntity pE = it.next();
	    		ProyectoDTO pDTO = ProyectoEntity2DTO(pE);
	    		lpDTO.add(pDTO);
	    	}
	    	
	        return lpDTO;
	    }
	    
	    
	    @Override
	    public Optional<ProyectoDTO> findById(int id) {
	    	Optional<bsc_proyecto_actividadEntity> oPE = data.findById(id);
	    	
	    	if (oPE.isPresent())
	    	{
	    		bsc_proyecto_actividadEntity pE = oPE.get();
	    		
	    		ProyectoDTO pDTO = ProyectoEntity2DTO(pE);
	        
	    		Optional<ProyectoDTO> opDTO = Optional.ofNullable(pDTO);
	        	
	    		return opDTO;
	    	}
	    	else
	    	{
	    		
	            return Optional.empty();    		
	    	}
	    }
	    
	    
	    @Override
	    public ProyectoDTO save(ProyectoDTO p) {
	    	bsc_proyecto_actividadEntity pE = proyectoDTO2Entity(p);
	        pE = data.save(pE);
	        ProyectoDTO pDTO = this.ProyectoEntity2DTO(pE);
	        return pDTO;
	    }
	    
	    
	    @Override
	    public void delete(int id){
	        data.deleteById(id);
	    }

	    
	    
	    
	 
}
