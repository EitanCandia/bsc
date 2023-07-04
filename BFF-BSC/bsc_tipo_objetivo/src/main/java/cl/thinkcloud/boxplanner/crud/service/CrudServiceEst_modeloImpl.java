package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.bsc_tipo_objetivoDTO;
import cl.thinkcloud.boxplanner.crud.entity.bsc_tipo_objetivoEntity;
import cl.thinkcloud.boxplanner.crud.repository.bsc_tipo_objetivoRepository;

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
    private bsc_tipo_objetivoRepository data;
    
    
    public bsc_tipo_objetivoEntity bsc_tipo_objetivoDTO2Entity(bsc_tipo_objetivoDTO toDTO)
    {
    	logger.info("Servicer-bsc_tipo_objetivoDTO2Entity");
        bsc_tipo_objetivoEntity toEntity = new bsc_tipo_objetivoEntity();
    	toEntity.setId(toDTO.getId());
    	toEntity.setBsc_tipo_objetivo_id_padre(toDTO.getBsc_tipo_objetivo_id_padre());
    	toEntity.setAlias(toDTO.getAlias());
    	toEntity.setDescripcion(toDTO.getDescripcion());
    	toEntity.setOrden(toDTO.getOrden());
    	toEntity.setNivel(toDTO.getNivel());
    	toEntity.setFecha_registro(toDTO.getFecha_registro());
    	toEntity.setNombre(toDTO.getNombre());
    	return toEntity;
    }
    
    public bsc_tipo_objetivoDTO bsc_tipo_objetivoEntity2DTO(bsc_tipo_objetivoEntity toE)
    {
    	logger.info("Servicer-bsc_tipo_objetivoEntity2DTO");
    	bsc_tipo_objetivoDTO toDTO = new bsc_tipo_objetivoDTO();
    	toDTO.setId(toE.getId());
    	toDTO.setBsc_tipo_objetivo_id_padre(toE.getBsc_tipo_objetivo_id_padre());
    	toDTO.setAlias(toE.getAlias());
    	toDTO.setDescripcion(toE.getDescripcion());
    	toDTO.setOrden(toE.getOrden());
    	toDTO.setNivel(toE.getNivel());
    	toDTO.setFecha_registro(toE.getFecha_registro());
    	toDTO.setNombre(toE.getNombre());
    	return toDTO;
    }
    
    
    @Override
    public List<bsc_tipo_objetivoDTO> findAll() {
    	List<bsc_tipo_objetivoDTO> ltoDTO = new ArrayList<bsc_tipo_objetivoDTO>();
    	
    	Iterable<bsc_tipo_objetivoEntity> itTOE = data.findAll();
    	
    	Iterator<bsc_tipo_objetivoEntity> it = itTOE.iterator();
    	
    	while (it.hasNext())
    	{
    		bsc_tipo_objetivoEntity toE = it.next();
    		bsc_tipo_objetivoDTO toDTO = bsc_tipo_objetivoEntity2DTO(toE);
    		ltoDTO.add(toDTO);
    	}
    	
        return ltoDTO;
    }

    @Override
    public Optional<bsc_tipo_objetivoDTO> findById(int id) {
    	Optional<bsc_tipo_objetivoEntity> otoE = data.findById(id);
    	
    	bsc_tipo_objetivoEntity toE = otoE.get();
    	
    	bsc_tipo_objetivoDTO toDTO = bsc_tipo_objetivoEntity2DTO(toE);
    	
    	Optional<bsc_tipo_objetivoDTO> otoDTO = Optional.ofNullable(toDTO);
    	
        return otoDTO;
    }

    @Override
    public bsc_tipo_objetivoDTO save(bsc_tipo_objetivoDTO to) {
    	bsc_tipo_objetivoEntity toE = bsc_tipo_objetivoDTO2Entity(to);
        data.save(toE);
        return to;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }


    

}