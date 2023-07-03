package cl.thinkcloud.boxplanner.crud.service;

import cl.thinkcloud.boxplanner.crud.dto.KpiMetaDTO;
import cl.thinkcloud.boxplanner.crud.entity.KpiMetaEntity;
import cl.thinkcloud.boxplanner.crud.repository.IKpiMetaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CrudServiceKpiMetaImpl implements ICrudService {

    private final Logger logger = LoggerFactory.getLogger(CrudServiceKpiMetaImpl.class);

    @Autowired
    private IKpiMetaRepository data;

    public KpiMetaEntity kpiMetaDTO2Entity(KpiMetaDTO kpiDTO) {
        logger.info("Service-kpiMetaDTO2Entity");
        KpiMetaEntity kpiEntity = new KpiMetaEntity();
        kpiEntity.setId(kpiDTO.getId());
        kpiEntity.setBscKpiId(kpiDTO.getBscKpiId());
        kpiEntity.setPeriodo(kpiDTO.getPeriodo());
        kpiEntity.setResultado(kpiDTO.getResultado());
        kpiEntity.setEvaluacion(kpiDTO.getEvaluacion());
        kpiEntity.setX1(kpiDTO.getX1());
        kpiEntity.setX2(kpiDTO.getX2());
        kpiEntity.setObservacion(kpiDTO.getObservacion());
        kpiEntity.setFechaRegistro(kpiDTO.getFechaRegistro());
        return kpiEntity;
    }

    public KpiMetaDTO kpiMetaEntity2DTO(KpiMetaEntity kpiEntity) {
        logger.info("Service-kpiMetaEntity2DTO");
        KpiMetaDTO kpiDTO = new KpiMetaDTO();
        kpiDTO.setId(kpiEntity.getId());
        kpiDTO.setBscKpiId(kpiEntity.getBscKpiId());
        kpiDTO.setPeriodo(kpiEntity.getPeriodo());
        kpiDTO.setResultado(kpiEntity.getResultado());
        kpiDTO.setEvaluacion(kpiEntity.getEvaluacion());
        kpiDTO.setX1(kpiEntity.getX1());
        kpiDTO.setX2(kpiEntity.getX2());
        kpiDTO.setObservacion(kpiEntity.getObservacion());
        kpiDTO.setFechaRegistro(kpiEntity.getFechaRegistro());
        return kpiDTO;
    }

    @Override
    public List<KpiMetaDTO> findAll() {
        List<KpiMetaDTO> kpiDTOList = new ArrayList<>();
        Iterable<KpiMetaEntity> kpiEntityIterable = data.findAll();
        kpiEntityIterable.forEach(kpiEntity -> kpiDTOList.add(kpiMetaEntity2DTO(kpiEntity)));
        return kpiDTOList;
    }

    @Override
    public Optional<KpiMetaDTO> findById(int id) {
        Optional<KpiMetaEntity> kpiEntityOptional = data.findById(id);
        return kpiEntityOptional.map(this::kpiMetaEntity2DTO);
    }

    @Override
    public KpiMetaDTO save(KpiMetaDTO kpiDTO) {
        KpiMetaEntity kpiEntity = kpiMetaDTO2Entity(kpiDTO);
        kpiEntity = data.save(kpiEntity);
        return kpiMetaEntity2DTO(kpiEntity);
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
