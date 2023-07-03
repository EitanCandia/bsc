package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.KpiMetaEntity;

@Repository
public interface IKpiMetaRepository extends CrudRepository<KpiMetaEntity, Integer> {
}
