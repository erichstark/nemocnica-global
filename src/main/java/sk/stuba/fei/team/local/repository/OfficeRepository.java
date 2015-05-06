package sk.stuba.fei.team.local.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.local.domain.Office;

import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
public interface OfficeRepository extends CrudRepository<Office, Long> {

    List<Office> findByNameContainingIgnoreCase(String name);
}
