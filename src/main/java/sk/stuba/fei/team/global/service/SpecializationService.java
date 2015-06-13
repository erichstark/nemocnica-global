package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Specialization;

import java.util.Date;
import java.util.List;

/**
 * Created by pallo on 5/7/15.
 */
public interface SpecializationService {

    Specialization findOne(Long id);

    List<Specialization> findByName(String name);

    List<Specialization> findByTimestamp(Date timestamp);

    Iterable<Specialization> findAll();

    boolean exists(Long id);

    void save(Specialization specialization);
}
