package sk.stuba.fei.team.global.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.global.domain.Insurance;

import java.util.Date;
import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

    List<Insurance> findByNameContainingIgnoreCase(String name);

    List<Insurance> findByUpdatedGreaterThan(Date timestamp);

    List<Insurance> findByEnabledTrue();
}
