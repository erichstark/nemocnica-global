package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Hours;

import java.util.List;

/**
 * Created by jakubrehak on 07/05/15.
 */
public interface HoursService {

    List<Hours> findByOfficeId(Long id);
    List<Hours> findByEmployeeId(Long id);
    List<Hours> findByEmployeeIdAndOfficeId(Long id, Long officeid);
}
