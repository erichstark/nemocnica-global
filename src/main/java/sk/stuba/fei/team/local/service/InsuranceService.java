package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Insurance;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface InsuranceService {

    Insurance findOne(Long id);

    List<Insurance> findByName(String name);

    Iterable<Insurance> findAll();

    boolean exists(Long id);

    void save(Insurance insurance);

    void delete(Long id);
}
