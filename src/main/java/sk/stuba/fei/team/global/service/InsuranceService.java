package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Insurance;

import java.util.Date;
import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
public interface InsuranceService {

    Insurance findOne(Long id);

    List<Insurance> findByName(String name);

    List<Insurance> findByTimestamp(Date timestamp);

    Iterable<Insurance> findAll();

    boolean exists(Long id);

    void save(Insurance insurance);
}
