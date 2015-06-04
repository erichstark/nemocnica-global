package sk.stuba.fei.team.global.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.global.domain.Facility;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface FacilityRepository extends CrudRepository<Facility, Long> {

    List<Facility> findByNameContainingIgnoreCase(String name);
}
