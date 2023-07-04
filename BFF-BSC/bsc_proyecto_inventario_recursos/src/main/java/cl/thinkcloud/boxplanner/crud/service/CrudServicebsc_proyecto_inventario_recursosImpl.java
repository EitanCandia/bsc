package cl.thinkcloud.boxplanner.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cl.thinkcloud.boxplanner.crud.entity.bsc_proyecto_inventario_recursos_Entity;
import cl.thinkcloud.boxplanner.crud.repository.Ibsc_proyecto_inventario_recursosRepository;


@Component
@Service
public class CrudServicebsc_proyecto_inventario_recursosImpl implements ICrudService {

    @Autowired
    private Ibsc_proyecto_inventario_recursosRepository data;

    @Override
    public List<bsc_proyecto_inventario_recursos_Entity> findAll() {
        return (List<bsc_proyecto_inventario_recursos_Entity>)data.findAll();
    }

    @Override
    public Optional<bsc_proyecto_inventario_recursos_Entity> findById(int id) {
        return data.findById(id);
    }

    @Override
    public bsc_proyecto_inventario_recursos_Entity save(bsc_proyecto_inventario_recursos_Entity p) {
    	bsc_proyecto_inventario_recursos_Entity bsc_proyecto_inventario_recursos = data.save(p);
        return bsc_proyecto_inventario_recursos;
    }

    @Override
    public void delete(int id){
        data.deleteById(id);
    }




}