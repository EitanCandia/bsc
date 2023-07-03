package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.ideasDTO;
import cl.thinkcloud.boxplanner.crud.entity.bsc_ideas;
import cl.thinkcloud.boxplanner.crud.repository.Ibsc_ideasrepository;

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
public class CrudServicePersonaImpl implements ICrudService {

    public final Logger logger = LoggerFactory.getLogger(CrudServicePersonaImpl.class);

    @Autowired
    private Ibsc_ideasrepository data;

    public bsc_ideas ideasDTO2Entity(ideasDTO pDTO) {
        logger.info("Servicer-ideasDTO2Entity");
        bsc_ideas pEntity = new bsc_ideas();
        pEntity.setId(pDTO.getId());
        pEntity.setNombre(pDTO.getNombre());
        pEntity.setDescripcion(pDTO.getDescripcion());
        pEntity.setIncluir(pDTO.getIncluir());
        pEntity.setFecha_registro(pDTO.getFecha_registro());
        return pEntity;
    }

    public ideasDTO ideasEntity2DTO(bsc_ideas pE) {
        logger.info("Servicer-ideasEntity2DTO");
        ideasDTO pDTO = new ideasDTO();
        pDTO.setId(pE.getId());
        pDTO.setNombre(pE.getNombre());
        pDTO.setDescripcion(pE.getDescripcion());
        pDTO.setIncluir(pE.isIncluir());
        pDTO.setFecha_registro(pE.getFecha_registro());
        return pDTO;
    }

    @Override
    public List<ideasDTO> findAll() {
        List<ideasDTO> lpDTO = new ArrayList<ideasDTO>();

        Iterable<bsc_ideas> itPE = data.findAll();

        Iterator<bsc_ideas> it = itPE.iterator();

        while (it.hasNext()) {
            bsc_ideas pE = it.next();
            ideasDTO pDTO = ideasEntity2DTO(pE);
            lpDTO.add(pDTO);
        }

        return lpDTO;
    }

    @Override
    public Optional<ideasDTO> findById(int id) {
        Optional<bsc_ideas> oPE = data.findById(id);

        if (oPE.isPresent()) {
            bsc_ideas pE = oPE.get();

            ideasDTO pDTO = ideasEntity2DTO(pE);

            Optional<ideasDTO> opDTO = Optional.ofNullable(pDTO);

            return opDTO;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public ideasDTO save(ideasDTO p) {
        bsc_ideas pE = ideasDTO2Entity(p);
        pE = data.save(pE);
        ideasDTO pDTO = this.ideasEntity2DTO(pE);
        return pDTO;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
