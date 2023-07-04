package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.Bsc_perspectivaDTO;
import cl.thinkcloud.boxplanner.crud.entity.Bsc_perspectivaEntity;
import cl.thinkcloud.boxplanner.crud.repository.Bsc_perspectivaRepository;

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
public class CrudServiceEst_modeloImpl implements ICrudService {

	public final Logger logger = LoggerFactory.getLogger(CrudServiceEst_modeloImpl.class);
	
    @Autowired
    private Bsc_perspectivaRepository data;
    
    
    public Bsc_perspectivaEntity bsc_perspectivaDTO2Entity(Bsc_perspectivaDTO toDTO)
    {
    	logger.info("Servicer-bsc_perspectivaDTO2Entity");
        Bsc_perspectivaEntity toEntity = new Bsc_perspectivaEntity();
    	toEntity.setId(toDTO.getId());
    	toEntity.setNombre(toDTO.getNombre());
    	toEntity.setAlias(toDTO.getAlias());
    	toEntity.setDescripcion(toDTO.getDescripcion());
    	toEntity.setOrden(toDTO.getOrden());
    	toEntity.setFecha_registro(toDTO.getFecha_registro());
    	return toEntity;
    }
    
    public Bsc_perspectivaDTO bsc_perspectivaEntity2DTO(Bsc_perspectivaEntity toE)
    {
    	logger.info("Servicer-bsc_perspectivaEntity2DTO");
    	Bsc_perspectivaDTO toDTO = new Bsc_perspectivaDTO();
    	toDTO.setId(toE.getId());
    	toDTO.setNombre(toE.getNombre());
    	toDTO.setAlias(toE.getAlias());
    	toDTO.setDescripcion(toE.getDescripcion());
    	toDTO.setOrden(toE.getOrden());
    	toDTO.setFecha_registro(toE.getFecha_registro());
    	return toDTO;
    }
    
    
    @Override
    public List<Bsc_perspectivaDTO> findAll() {
    	List<Bsc_perspectivaDTO> ltoDTO = new ArrayList<Bsc_perspectivaDTO>();
    	
    	Iterable<Bsc_perspectivaEntity> itTOE = data.findAll();
    	
    	Iterator<Bsc_perspectivaEntity> it = itTOE.iterator();
    	
    	while (it.hasNext())
    	{
    		Bsc_perspectivaEntity toE = it.next();
    		Bsc_perspectivaDTO toDTO = bsc_perspectivaEntity2DTO(toE);
    		ltoDTO.add(toDTO);
    	}
    	
        return ltoDTO;
    }

    @Override
    public Optional<Bsc_perspectivaDTO> findById(int id) {
    	Optional<Bsc_perspectivaEntity> otoE = data.findById(id);
    	
    	Bsc_perspectivaEntity toE = otoE.get();
    	
    	Bsc_perspectivaDTO toDTO = bsc_perspectivaEntity2DTO(toE);
    	
    	Optional<Bsc_perspectivaDTO> otoDTO = Optional.ofNullable(toDTO);
    	
        return otoDTO;
    }

    @Override
    public Bsc_perspectivaDTO save(Bsc_perspectivaDTO to) {
    	Bsc_perspectivaEntity toE = bsc_perspectivaDTO2Entity(to);
        data.save(toE);
        return to;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }


    

}