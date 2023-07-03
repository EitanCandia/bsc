package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.kapi_final_DTO;
import cl.thinkcloud.boxplanner.crud.entity.kapi_final_Entity;
import cl.thinkcloud.boxplanner.crud.repository.Ikapi_final_Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CrudServicekapi_finalImpl implements ICrudService {

    private final Logger logger = LoggerFactory.getLogger(CrudServicekapi_finalImpl.class);

    @Autowired
    private Ikapi_final_Repository data;

    public kapi_final_Entity kapi_final_DTO2Entity(kapi_final_DTO kapi_final_DTO) {
        logger.info("Service-kapi_final_DTO2Entity");
        kapi_final_Entity kapi_final_Entity = new kapi_final_Entity();
        kapi_final_Entity.setId(kapi_final_DTO.getId());
        kapi_final_Entity.setBscproyectoid(kapi_final_DTO.getBscproyectoid());
        kapi_final_Entity.setBscobjetivoid(kapi_final_DTO.getBscobjetivoid());
        kapi_final_Entity.setNombre(kapi_final_DTO.getNombre());
        kapi_final_Entity.setAlias(kapi_final_DTO.getAlias());
        kapi_final_Entity.setDescripcion(kapi_final_DTO.getDescripcion());
        kapi_final_Entity.setOrden(kapi_final_DTO.getOrden());
        kapi_final_Entity.setFormula(kapi_final_DTO.getFormula());
        kapi_final_Entity.setFecharegistro(kapi_final_DTO.getFecharegistro());
        // Mapear los demás atributos
        return kapi_final_Entity;
    }

    public kapi_final_DTO kapi_final_Entity2DTO(kapi_final_Entity kapi_final_Entity) {
        logger.info("Service-kapi_final_Entity2DTO");
        kapi_final_DTO kapi_final_DTO = new kapi_final_DTO();
        kapi_final_DTO.setId(kapi_final_Entity.getId());
        kapi_final_DTO.setBscproyectoid(kapi_final_Entity.getBscproyectoid());
        kapi_final_DTO.setBscobjetivoid(kapi_final_Entity.getBscobjetivoid());
        kapi_final_DTO.setNombre(kapi_final_Entity.getNombre());
        kapi_final_DTO.setAlias(kapi_final_Entity.getAlias());
        kapi_final_DTO.setDescripcion(kapi_final_Entity.getDescripcion());
        kapi_final_DTO.setOrden(kapi_final_Entity.getOrden());
        kapi_final_DTO.setFormula(kapi_final_Entity.getFormula());
        kapi_final_DTO.setFecharegistro(kapi_final_Entity.getFecharegistro());
        // Mapear los demás atributos
        return kapi_final_DTO;
    }

    @Override
    public List<kapi_final_DTO> findAll() {
        List<kapi_final_DTO> kapi_final_DTOList = new ArrayList<>();
        Iterable<kapi_final_Entity> kapi_final_EntityIterable = data.findAll();
        Iterator<kapi_final_Entity> iterator = kapi_final_EntityIterable.iterator();
        while (iterator.hasNext()) {
            kapi_final_Entity kapi_final_Entity = iterator.next();
            kapi_final_DTO kapi_final_DTO = kapi_final_Entity2DTO(kapi_final_Entity);
            kapi_final_DTOList.add(kapi_final_DTO);
        }
        return kapi_final_DTOList;
    }

    @Override
    public Optional<kapi_final_DTO> findById(int id) {
        Optional<kapi_final_Entity> optionalkapi_final_Entity = data.findById(id);
        if (optionalkapi_final_Entity.isPresent()) {
            kapi_final_Entity kapi_final_Entity = optionalkapi_final_Entity.get();
            kapi_final_DTO kapi_final_DTO = kapi_final_Entity2DTO(kapi_final_Entity);
            return Optional.of(kapi_final_DTO);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public kapi_final_DTO save(kapi_final_DTO kapi_final_DTO) {
        kapi_final_Entity kapi_final_Entity = kapi_final_DTO2Entity(kapi_final_DTO);
        kapi_final_Entity = data.save(kapi_final_Entity);
        kapi_final_DTO savedkapi_final_DTO = kapi_final_Entity2DTO(kapi_final_Entity);
        return savedkapi_final_DTO;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
