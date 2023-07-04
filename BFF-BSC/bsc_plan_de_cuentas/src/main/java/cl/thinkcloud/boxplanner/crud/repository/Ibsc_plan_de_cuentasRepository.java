package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.bsc_plan_de_cuentasEntity;

@Repository
public interface Ibsc_plan_de_cuentasRepository extends CrudRepository <bsc_plan_de_cuentasEntity, Integer> {

}
