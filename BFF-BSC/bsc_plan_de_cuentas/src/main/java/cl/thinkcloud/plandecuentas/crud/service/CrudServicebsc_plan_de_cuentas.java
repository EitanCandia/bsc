package cl.thinkcloud.plandecuentas.crud.service;

import cl.thinkcloud.plandecuentas.crud.dto.bsc_plan_de_cuentasDTO;
import cl.thinkcloud.plandecuentas.crud.entity.bsc_plan_de_cuentasEntity;
import cl.thinkcloud.plandecuentas.crud.repository.Ibsc_plan_de_cuentasRepository;

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
public class CrudServicebsc_plan_de_cuentas implements ICrudService {
	public final Logger logger = LoggerFactory.getLogger(CrudServicebsc_plan_de_cuentas.class);


    @Autowired
    private Ibsc_plan_de_cuentasRepository data;
    
    public bsc_plan_de_cuentasEntity bsc_plan_de_cuentasDTO2Entity(bsc_plan_de_cuentasDTO pcDTO)
    {
    	logger.info("Servicer-bsc_plan_de_cuentasDTO2Entity");
    	bsc_plan_de_cuentasEntity pcEntity = new bsc_plan_de_cuentasEntity();
    	pcEntity.setId(pcDTO.getId());
    	pcEntity.setBscPlanDeCuentasIdPadre(pcDTO.getBscPlanDeCuentasIdPadre());
    	pcEntity.setNivel(pcDTO.getNivel());
    	pcEntity.setCodigo(pcDTO.getCodigo());
    	pcEntity.setNombre(pcDTO.getNombre());
    	pcEntity.setPresupuestoAnualFinal(pcDTO.getPresupuestoAnualFinal());
    	pcEntity.setPresupuestoAnualOriginal(pcDTO.getPresupuestoAnualOriginal());
    	pcEntity.setObservacion(pcDTO.getObservacion());
    	pcEntity.setReasignable(pcDTO.isReasignable());
    	pcEntity.setMostrarEnItems(pcDTO.isMostrarEnItems());
    	pcEntity.setFechaRegistro(pcDTO.getFechaRegistro());
    	return pcEntity;
    }
    
    public bsc_plan_de_cuentasDTO bsc_plan_de_cuentasEntity2DTO(bsc_plan_de_cuentasEntity IiE)
    {
    	logger.info("Servicer-bsc_plan_de_cuentasEntity2DTO");
    	bsc_plan_de_cuentasDTO pcDTO = new bsc_plan_de_cuentasDTO();
    	pcDTO.setId(IiE.getId());
    	pcDTO.setBscPlanDeCuentasIdPadre(IiE.getBscPlanDeCuentasIdPadre());
    	pcDTO.setNivel(IiE.getNivel());
    	pcDTO.setCodigo(IiE.getCodigo());
    	pcDTO.setNombre(IiE.getNombre());
    	pcDTO.setPresupuestoAnualFinal(IiE.getPresupuestoAnualFinal());
    	pcDTO.setPresupuestoAnualOriginal(IiE.getPresupuestoAnualOriginal());
    	pcDTO.setObservacion(IiE.getObservacion());
    	pcDTO.setReasignable(IiE.isReasignable());
    	pcDTO.setMostrarEnItems(IiE.isMostrarEnItems());
    	pcDTO.setFechaRegistro(IiE.getFechaRegistro());
    	return pcDTO;
    }

    @Override
    public List<bsc_plan_de_cuentasDTO> findAll() {
    	List<bsc_plan_de_cuentasDTO> lpcDTO = new ArrayList<bsc_plan_de_cuentasDTO>();
    	
    	Iterable<bsc_plan_de_cuentasEntity> itIiE = data.findAll();
    	
    	Iterator<bsc_plan_de_cuentasEntity> it = itIiE.iterator();
    	
    	while (it.hasNext())
    	{
    		bsc_plan_de_cuentasEntity IiE = it.next();
    		bsc_plan_de_cuentasDTO pDTO = bsc_plan_de_cuentasEntity2DTO(IiE);
    		lpcDTO.add(pDTO);
    	}
    	
        return lpcDTO;
    }

    @Override
    public Optional<bsc_plan_de_cuentasDTO> findById(int id) {
    	Optional<bsc_plan_de_cuentasEntity> oIiE = data.findById(id);
    	
    	if (oIiE.isPresent())
    	{
    		bsc_plan_de_cuentasEntity IiE = oIiE.get();
    		
    		bsc_plan_de_cuentasDTO pcDTO = bsc_plan_de_cuentasEntity2DTO(IiE);
        
    		Optional<bsc_plan_de_cuentasDTO> opcDTO = Optional.ofNullable(pcDTO);
        	
    		return opcDTO;
    	}
    	else
    	{
    		
            return Optional.empty();    		
    	}
    	
    	
    	
    	

    }
    @Override
    public bsc_plan_de_cuentasDTO save(bsc_plan_de_cuentasDTO Ii) {
    	bsc_plan_de_cuentasEntity IiE = bsc_plan_de_cuentasDTO2Entity(Ii);
        IiE = data.save(IiE);
        bsc_plan_de_cuentasDTO pcDTO = this.bsc_plan_de_cuentasEntity2DTO(IiE);
        return pcDTO;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
    

}