package sk.stuba.fei.nemocnica.service;

import sk.stuba.fei.nemocnica.domain.Poistovna;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface PoistovnaService {

    Poistovna findOne(Long id);

    List<Poistovna> findByName(String name);

    Iterable<Poistovna> findAll();

    boolean exists(Long id);

    void save(Poistovna ambulancia);

    void delete(Long id);
}
