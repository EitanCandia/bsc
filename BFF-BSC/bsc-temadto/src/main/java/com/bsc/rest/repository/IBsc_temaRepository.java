package com.bsc.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.bsc.rest.entity.Bsc_temaEntity;
@Repository
public interface IBsc_temaRepository extends CrudRepository<Bsc_temaEntity,Integer> {

}
