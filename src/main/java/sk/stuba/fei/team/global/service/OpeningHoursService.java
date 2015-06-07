package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.OpeningHours;

import java.util.List;

/**
 * Created by jakubrehak on 07/05/15.
 */
public interface OpeningHoursService {

    List<OpeningHours> findByOfficeId(Long id);
    List<OpeningHours> findByEmployeeId(Long id);
    List<OpeningHours> findByEmployeeIdAndOfficeId(Long id, Long officeid);
}
