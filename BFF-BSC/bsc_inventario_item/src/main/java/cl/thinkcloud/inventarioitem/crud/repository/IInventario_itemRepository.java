package cl.thinkcloud.inventarioitem.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.inventarioitem.crud.entity.Inventario_itemEntity;

@Repository
public interface IInventario_itemRepository extends CrudRepository <Inventario_itemEntity, Integer> {

}
