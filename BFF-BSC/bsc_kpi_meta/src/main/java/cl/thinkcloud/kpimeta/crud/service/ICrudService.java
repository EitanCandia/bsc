package cl.thinkcloud.kpimeta.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.kpimeta.crud.dto.KpiMetaDTO;

public interface ICrudService {
    public List<KpiMetaDTO> findAll();
    public Optional<KpiMetaDTO> findById(int id);
    public KpiMetaDTO save(KpiMetaDTO kpiMeta);
    public void delete(int id);
}
