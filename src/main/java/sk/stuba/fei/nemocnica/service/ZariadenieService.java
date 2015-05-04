package sk.stuba.fei.nemocnica.service;

import sk.stuba.fei.nemocnica.domain.Zariadenie;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface ZariadenieService {

    Zariadenie findOne(Long id);

    List<Zariadenie> findByName(String name);

    Iterable<Zariadenie> findAll();

    boolean exists(Long id);

    void save(Zariadenie zariadenie);

    void delete(Long id);
}
