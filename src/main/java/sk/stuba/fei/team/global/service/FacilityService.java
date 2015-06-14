package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Facility;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface FacilityService {

    Facility findOne(Long id);

    List<Facility> findByName(String name);

    Iterable<Facility> findAll();

    boolean exists(Long id);

    void save(Facility facility);
}
