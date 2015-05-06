package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Office;

import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
public interface OfficeService {

    Office findOne(Long id);

    List<Office> findByName(String name);

    Iterable<Office> findAll();

    boolean exists(Long id);

    void save(Office office);

    void delete(Long id);
}
