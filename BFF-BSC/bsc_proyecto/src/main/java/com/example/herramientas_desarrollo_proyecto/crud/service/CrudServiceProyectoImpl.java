package com.example.herramientas_desarrollo_proyecto.crud.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.herramientas_desarrollo_proyecto.crud.dto.ProyectoDTO;
import com.example.herramientas_desarrollo_proyecto.crud.entity.ProyectoEntity;
import com.example.herramientas_desarrollo_proyecto.crud.repository.IProyectoRepository;



@Component
@Service
public class CrudServiceProyectoImpl implements ICrudService {
    @Autowired
    private IProyectoRepository data;


    public ProyectoEntity proyectoDTO2Entity(ProyectoDTO pDTO){

        ProyectoEntity pEntity = new ProyectoEntity();
        pEntity.setId(pDTO.getId());  
        pEntity.setOrg_persona_id_responsable(pDTO.getOrg_persona_id_responsable());
        pEntity.setOrg_departamento_id_responsable(pDTO.getOrg_departamento_id_responsable());
        pEntity.setBsc_tipo_proyecto_id(pDTO.getBsc_tipo_proyecto_id());
        pEntity.setBsc_proceso_id(pDTO.getBsc_proceso_id());
        pEntity.setNombre(pDTO.getNombre());
        pEntity.setAlias(pDTO.getAlias());
        pEntity.setDescripcion(pDTO.getDescripcion());
        pEntity.setOrden(pDTO.getOrden());
        pEntity.setCodigo(pDTO.getCodigo());
        pEntity.setIncluir(pDTO.isIncluir());
        pEntity.setObjetivo_general(pDTO.getObjetivo_general());
        pEntity.setPresupuesto(pDTO.getPresupuesto());
        pEntity.setObservaciones(pDTO.getObservaciones());
        pEntity.setFechaRegistro(pDTO.getFechaRegistro());
        
        return pEntity;
    }

    public ProyectoDTO proyectoEntity2DTO(ProyectoEntity pE){

        ProyectoDTO pDTO = new ProyectoDTO();
        pDTO.setId(pE.getId());
        pDTO.setOrg_persona_id_responsable(pE.getOrg_persona_id_responsable());
        pDTO.setOrg_departamento_id_responsable(pE.getOrg_departamento_id_responsable());
        pDTO.setBsc_tipo_proyecto_id(pE.getBsc_tipo_proyecto_id());
        pDTO.setBsc_proceso_id(pE.getBsc_proceso_id());
        pDTO.setNombre(pE.getNombre());
        pDTO.setAlias(pE.getAlias());
        pDTO.setDescripcion(pE.getDescripcion());
        pDTO.setOrden(pE.getOrden());
        pDTO.setCodigo(pE.getCodigo());
        pDTO.setIncluir(pE.isIncluir());
        pDTO.setObjetivo_general(pE.getObjetivo_general());
        pDTO.setPresupuesto(pE.getPresupuesto());
        pDTO.setObservaciones(pE.getObservaciones());
        pDTO.setFechaRegistro(pE.getFechaRegistro());

        return pDTO;
    }
    @Override
    public List<ProyectoDTO> findAll() {
        List<ProyectoDTO> lpDTO = new ArrayList<ProyectoDTO>();

        Iterable<ProyectoEntity> itPE = data.findAll();

        Iterator<ProyectoEntity> it = itPE.iterator();


        while(it.hasNext()){
            ProyectoEntity pE = it.next();

            ProyectoDTO pDTO = proyectoEntity2DTO(pE);
            lpDTO.add(pDTO);
        }

        return lpDTO;
    }

    @Override
    public Optional<ProyectoDTO> findById(int id) {

        Optional<ProyectoEntity> oPE = data.findById(id);

        ProyectoEntity pE = oPE.get();

        ProyectoDTO pDTO = proyectoEntity2DTO(pE);

        Optional<ProyectoDTO> opDTO = Optional.ofNullable(pDTO);
        return opDTO;
    }

    @Override
    public ProyectoDTO save(ProyectoDTO p) {

        ProyectoEntity pE = proyectoDTO2Entity(p);
        pE = data.save(pE);

        return p;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }
     
}
