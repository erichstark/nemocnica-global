package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Hours;

import java.util.List;

/**
 * Created by jakubrehak on 07/05/15.
 */
public interface HoursService {

    List<Hours> findByOfficeId(Long id);
    List<Hours> findByEmployeeId(Long id);
    List<Hours> findByEmployeeIdAndOfficeId(Long id, Long officeid);
}
