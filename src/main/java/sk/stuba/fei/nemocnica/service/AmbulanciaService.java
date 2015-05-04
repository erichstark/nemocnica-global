package sk.stuba.fei.nemocnica.service;

import sk.stuba.fei.nemocnica.domain.Ambulancia;

import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
public interface AmbulanciaService {

    Ambulancia findOne(Long id);

    List<Ambulancia> findByName(String name);

    Iterable<Ambulancia> findAll();

    boolean exists(Long id);

    void save(Ambulancia ambulancia);

    void delete(Long id);
}
