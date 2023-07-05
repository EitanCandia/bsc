package cl.thinkcloud.inventarioitem.crud.service;

import java.util.List;
import java.util.Optional;

import cl.thinkcloud.inventarioitem.crud.dto.Inventario_itemDTO;
import cl.thinkcloud.inventarioitem.crud.entity.Inventario_itemEntity;

public interface ICrudService {
    public List<Inventario_itemDTO> findAll();
    public Optional<Inventario_itemDTO> findById(int id);
    public Inventario_itemDTO save(Inventario_itemDTO inventario_item);
    public void delete(int id);
}
