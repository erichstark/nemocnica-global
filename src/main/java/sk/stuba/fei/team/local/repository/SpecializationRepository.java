package sk.stuba.fei.team.local.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.local.domain.Specialization;

import java.util.List;

/**
 * Created by pallo on 5/7/15.
 */
public interface SpecializationRepository extends CrudRepository<Specialization, Long> {

    List<Specialization> findByNameContainingIgnoreCase(String name);
}
