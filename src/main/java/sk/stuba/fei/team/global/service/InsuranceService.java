package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Insurance;

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
