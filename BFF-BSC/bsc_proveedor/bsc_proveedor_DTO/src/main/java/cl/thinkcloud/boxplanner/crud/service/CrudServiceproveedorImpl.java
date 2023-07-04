package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.proveedorDTO;
import cl.thinkcloud.boxplanner.crud.entity.proveedorEntity;
import cl.thinkcloud.boxplanner.crud.repository.IproveedorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceproveedorImpl implements ICrudService {

    private final Logger logger = LoggerFactory.getLogger(CrudServiceproveedorImpl.class);

    @Autowired
    private IproveedorRepository data;

    public proveedorEntity proveedorDTO2Entity(proveedorDTO proveedorDTO) {
        logger.info("Service-proveedorDTO2Entity");
        proveedorEntity proveedorEntity = new proveedorEntity();

        proveedorEntity.setId(proveedorDTO.getId());
        proveedorEntity.setOrganizacion(proveedorDTO.getOrganizacion());
        proveedorEntity.setContacto(proveedorDTO.getContacto());
        proveedorEntity.setCargo(proveedorDTO.getCargo());
        proveedorEntity.setEmail(proveedorDTO.getEmail());
        proveedorEntity.setTelefono_trabajo(proveedorDTO.getTelefono_trabajo());
        proveedorEntity.setTelefono_movil(proveedorDTO.getTelefono_movil());
        proveedorEntity.setTelefono_personal(proveedorDTO.getTelefono_personal());
        proveedorEntity.setDireccion(proveedorDTO.getDireccion());
        proveedorEntity.setCiudad(proveedorDTO.getCiudad());
        proveedorEntity.setEstado_provincia(proveedorDTO.getEstado_provincia());
        proveedorEntity.setPais_region(proveedorDTO.getPais_region());
        proveedorEntity.setCodigo_postal(proveedorDTO.getCodigo_postal());
        proveedorEntity.setPagina_web(proveedorDTO.getPagina_web());
        proveedorEntity.setObservaciones(proveedorDTO.getObservaciones());
        proveedorEntity.setFecha_registro(proveedorDTO.getFecha_registro());

        return proveedorEntity;
    }

    public proveedorDTO proveedorEntity2DTO(proveedorEntity proveedorEntity) {
        logger.info("Service-proveedorEntity2DTO");
        proveedorDTO proveedorDTO = new proveedorDTO();

        proveedorDTO.setId(proveedorEntity.getId());
        proveedorDTO.setOrganizacion(proveedorEntity.getOrganizacion());
        proveedorDTO.setContacto(proveedorEntity.getContacto());
        proveedorDTO.setCargo(proveedorEntity.getCargo());
        proveedorDTO.setEmail(proveedorEntity.getEmail());
        proveedorDTO.setTelefono_trabajo(proveedorEntity.getTelefono_trabajo());
        proveedorDTO.setTelefono_movil(proveedorEntity.getTelefono_movil());
        proveedorDTO.setTelefono_personal(proveedorEntity.getTelefono_personal());
        proveedorDTO.setDireccion(proveedorEntity.getDireccion());
        proveedorDTO.setCiudad(proveedorEntity.getCiudad());
        proveedorDTO.setEstado_provincia(proveedorEntity.getEstado_provincia());
        proveedorDTO.setPais_region(proveedorEntity.getPais_region());
        proveedorDTO.setCodigo_postal(proveedorEntity.getCodigo_postal());
        proveedorDTO.setPagina_web(proveedorEntity.getPagina_web());
        proveedorDTO.setObservaciones(proveedorEntity.getObservaciones());
        proveedorDTO.setFecha_registro(proveedorEntity.getFecha_registro());

        return proveedorDTO;
    }

    @Override
    public List<proveedorDTO> findAll() {
        List<proveedorDTO> proveedorDTOList = new ArrayList<>();
        Iterable<proveedorEntity> proveedorEntityIterable = data.findAll();
        proveedorEntityIterable.forEach(proveedorEntity -> proveedorDTOList.add(proveedorEntity2DTO(proveedorEntity)));
        return proveedorDTOList;
    }

    @Override
    public Optional<proveedorDTO> findById(int id) {
        Optional<proveedorEntity> proveedorEntityOptional = data.findById(id);
        return proveedorEntityOptional.map(this::proveedorEntity2DTO);
    }

    @Override
    public proveedorDTO save(proveedorDTO proveedorDTO) {
        proveedorEntity proveedorEntity = proveedorDTO2Entity(proveedorDTO);
        proveedorEntity = data.save(proveedorEntity);
        return proveedorEntity2DTO(proveedorEntity);
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
