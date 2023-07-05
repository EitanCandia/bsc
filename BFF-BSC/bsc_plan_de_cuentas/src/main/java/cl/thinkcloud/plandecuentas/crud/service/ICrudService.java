package cl.thinkcloud.plandecuentas.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.plandecuentas.crud.dto.bsc_plan_de_cuentasDTO;
import cl.thinkcloud.plandecuentas.crud.entity.bsc_plan_de_cuentasEntity;

public interface ICrudService {
    public List<bsc_plan_de_cuentasDTO> findAll();
    public Optional<bsc_plan_de_cuentasDTO> findById(int id);
    public bsc_plan_de_cuentasDTO save(bsc_plan_de_cuentasDTO bsc_plan_de_cuentasEntity);
    public void delete(int id);
}
