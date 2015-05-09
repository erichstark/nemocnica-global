package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Specialization;

import java.util.List;

/**
 * Created by pallo on 5/7/15.
 */
public interface SpecializationService {

    Specialization findOne(Long id);

    List<Specialization> findByName(String name);

    Iterable<Specialization> findAll();

    boolean exists(Long id);

    void save(Specialization specialization);

    void delete(Long id);
}
