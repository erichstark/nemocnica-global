package sk.stuba.fei.nemocnica.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.nemocnica.domain.Ambulancia;

import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
public interface AmbulanciaRepository extends CrudRepository<Ambulancia, Long> {

    List<Ambulancia> findByNameContainingIgnoreCase(String name);
}
