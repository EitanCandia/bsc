package cl.thinkcloud.kpimeta.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.kpimeta.crud.entity.KpiMetaEntity;

@Repository
public interface IKpiMetaRepository extends CrudRepository<KpiMetaEntity, Integer> {
}
