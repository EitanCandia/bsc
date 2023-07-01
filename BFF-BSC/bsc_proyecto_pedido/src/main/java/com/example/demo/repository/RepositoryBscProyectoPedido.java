package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import  com.example.demo.entity.EntityBscProyectoPedido;

@Repository
public interface RepositoryBscProyectoPedido extends  CrudRepository <EntityBscProyectoPedido, Integer> {

}
