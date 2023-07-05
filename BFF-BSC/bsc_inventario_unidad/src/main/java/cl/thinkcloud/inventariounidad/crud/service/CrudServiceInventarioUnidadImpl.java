package cl.thinkcloud.inventariounidad.crud.service;

import cl.thinkcloud.inventariounidad.crud.dto.InventarioUnidadDTO;
import cl.thinkcloud.inventariounidad.crud.entity.InventarioUnidadEntity;
import cl.thinkcloud.inventariounidad.crud.repository.InventarioUnidadRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceInventarioUnidadImpl implements ICrudService {

    private final Logger logger = LoggerFactory.getLogger(CrudServiceInventarioUnidadImpl.class);

    @Autowired
    private InventarioUnidadRepository data;

    public InventarioUnidadEntity inventarioUnidadDTO2Entity(InventarioUnidadDTO inventarioDTO) {
        logger.info("Service-inventarioUnidadDTO2Entity");
        InventarioUnidadEntity inventarioEntity = new InventarioUnidadEntity();
        inventarioEntity.setId(inventarioDTO.getId());
        inventarioEntity.setNombre(inventarioDTO.getNombre());
        inventarioEntity.setAlias(inventarioDTO.getAlias());
        inventarioEntity.setDescripcion(inventarioDTO.getDescripcion());
        inventarioEntity.setOrden(inventarioDTO.getOrden());
        inventarioEntity.setFechaRegistro(inventarioDTO.getFechaRegistro());
        return inventarioEntity;
    }

    public InventarioUnidadDTO inventarioUnidadEntity2DTO(InventarioUnidadEntity inventarioEntity) {
        logger.info("Service-inventarioUnidadEntity2DTO");
        InventarioUnidadDTO inventarioDTO = new InventarioUnidadDTO();
        inventarioDTO.setId(inventarioEntity.getId());
        inventarioDTO.setNombre(inventarioEntity.getNombre());
        inventarioDTO.setAlias(inventarioEntity.getAlias());
        inventarioDTO.setDescripcion(inventarioEntity.getDescripcion());
        inventarioDTO.setOrden(inventarioEntity.getOrden());
        inventarioDTO.setFechaRegistro(inventarioEntity.getFechaRegistro());
        return inventarioDTO;
    }

    @Override
    public List<InventarioUnidadDTO> findAll() {
        List<InventarioUnidadDTO> inventarioDTOList = new ArrayList<>();
        Iterable<InventarioUnidadEntity> inventarioEntityIterable = data.findAll();
        inventarioEntityIterable
                .forEach(inventarioEntity -> inventarioDTOList.add(inventarioUnidadEntity2DTO(inventarioEntity)));
        return inventarioDTOList;
    }

    @Override
    public Optional<InventarioUnidadDTO> findById(int id) {
        Optional<InventarioUnidadEntity> inventarioEntityOptional = data.findById(id);
        return inventarioEntityOptional.map(this::inventarioUnidadEntity2DTO);
    }

    @Override
    public InventarioUnidadDTO save(InventarioUnidadDTO inventarioDTO) {
        InventarioUnidadEntity inventarioEntity = inventarioUnidadDTO2Entity(inventarioDTO);
        inventarioEntity = data.save(inventarioEntity);
        return inventarioUnidadEntity2DTO(inventarioEntity);
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
