package sk.stuba.fei.team.local.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.local.domain.Insurance;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

    List<Insurance> findByNameContainingIgnoreCase(String name);
}
