
package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.bsc_ideas;



@Repository
public interface Ibsc_ideasrepository extends CrudRepository <bsc_ideas, Integer> {
}
