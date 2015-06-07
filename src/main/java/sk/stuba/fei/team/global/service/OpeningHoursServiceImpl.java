package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.OpeningHours;
import sk.stuba.fei.team.global.repository.HoursRepository;

import java.util.List;


/**
 * Created by jakubrehak on 07/05/15.
 */

@Component("hoursService")
@Transactional
public class OpeningHoursServiceImpl implements OpeningHoursService {

    @Autowired
    HoursRepository hoursRepository;

    @Override
    public List<OpeningHours> findByOfficeId(Long id){

        return hoursRepository.findByOfficeId(id);
    }

    @Override
    public List<OpeningHours> findByEmployeeId(Long id){

        return hoursRepository.findByEmployeeId(id);
    }

    @Override
    public List<OpeningHours> findByEmployeeIdAndOfficeId(Long id, Long officeid){
        return hoursRepository.findByEmployeeIdAndOfficeId(id, officeid);
    }
}
