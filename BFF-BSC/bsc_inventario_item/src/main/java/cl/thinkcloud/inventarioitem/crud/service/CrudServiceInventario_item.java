package cl.thinkcloud.inventarioitem.crud.service;

import cl.thinkcloud.inventarioitem.crud.dto.Inventario_itemDTO;
import cl.thinkcloud.inventarioitem.crud.entity.Inventario_itemEntity;
import cl.thinkcloud.inventarioitem.crud.repository.IInventario_itemRepository;

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
public class CrudServiceInventario_item implements ICrudService {
	public final Logger logger = LoggerFactory.getLogger(CrudServiceInventario_item.class);


    @Autowired
    private IInventario_itemRepository data;
    
    public Inventario_itemEntity inventario_itemDTO2Entity(Inventario_itemDTO IiDTO)
    {
    	logger.info("Servicer-inventario_itemDTO2Entity");
    	Inventario_itemEntity IiEntity = new Inventario_itemEntity();
    	IiEntity.setId(IiDTO.getId());
    	IiEntity.setOrgPersonaIdRegistradoPor(IiDTO.getOrgPersonaIdRegistradoPor());
    	IiEntity.setBscPlanDeCuentasId(IiDTO.getBscPlanDeCuentasId());
    	IiEntity.setBscProveedorId(IiDTO.getBscProveedorId());
    	IiEntity.setBscInventarioUnidadId(IiDTO.getBscInventarioUnidadId());
    	IiEntity.setNombre(IiDTO.getNombre());
    	IiEntity.setAlias(IiDTO.getAlias());
    	IiEntity.setDescripcion(IiDTO.getDescripcion());
    	IiEntity.setPrecioConImpuesto(IiDTO.getPrecioConImpuesto());
    	IiEntity.setUrl(IiDTO.getUrl());
    	IiEntity.setObservacion(IiDTO.getObservacion());
    	IiEntity.setFecha_registro(IiDTO.getFecha_registro());
    	return IiEntity;
    }
    
    public Inventario_itemDTO inventario_itemEntity2DTO(Inventario_itemEntity IiE)
    {
    	logger.info("Servicer-inventario_itemEntity2DTO");
    	Inventario_itemDTO IiDTO = new Inventario_itemDTO();
    	IiDTO.setId(IiE.getId());
    	IiDTO.setOrgPersonaIdRegistradoPor(IiE.getOrgPersonaIdRegistradoPor());
    	IiDTO.setBscPlanDeCuentasId(IiE.getBscPlanDeCuentasId());
    	IiDTO.setBscProveedorId(IiE.getBscProveedorId());
    	IiDTO.setBscInventarioUnidadId(IiE.getBscInventarioUnidadId());
    	IiDTO.setNombre(IiE.getNombre());
    	IiDTO.setAlias(IiE.getAlias());
    	IiDTO.setDescripcion(IiE.getDescripcion());
    	IiDTO.setPrecioConImpuesto(IiE.getPrecioConImpuesto());
    	IiDTO.setUrl(IiE.getUrl());
    	IiDTO.setObservacion(IiE.getObservacion());
    	IiDTO.setFecha_registro(IiE.getFecha_registro());
    	return IiDTO;
    }

    @Override
    public List<Inventario_itemDTO> findAll() {
    	List<Inventario_itemDTO> lIiDTO = new ArrayList<Inventario_itemDTO>();
    	
    	Iterable<Inventario_itemEntity> itIiE = data.findAll();
    	
    	Iterator<Inventario_itemEntity> it = itIiE.iterator();
    	
    	while (it.hasNext())
    	{
    		Inventario_itemEntity IiE = it.next();
    		Inventario_itemDTO pDTO = inventario_itemEntity2DTO(IiE);
    		lIiDTO.add(pDTO);
    	}
    	
        return lIiDTO;
    }

    @Override
    public Optional<Inventario_itemDTO> findById(int id) {
    	Optional<Inventario_itemEntity> oIiE = data.findById(id);
    	
    	if (oIiE.isPresent())
    	{
    		Inventario_itemEntity IiE = oIiE.get();
    		
    		Inventario_itemDTO IiDTO = inventario_itemEntity2DTO(IiE);
        
    		Optional<Inventario_itemDTO> oiiDTO = Optional.ofNullable(IiDTO);
        	
    		return oiiDTO;
    	}
    	else
    	{
    		
            return Optional.empty();    		
    	}
    	
    	
    	
    	

    }
    @Override
    public Inventario_itemDTO save(Inventario_itemDTO Ii) {
    	Inventario_itemEntity IiE = inventario_itemDTO2Entity(Ii);
        IiE = data.save(IiE);
        Inventario_itemDTO IiDTO = this.inventario_itemEntity2DTO(IiE);
        return IiDTO;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
    

}