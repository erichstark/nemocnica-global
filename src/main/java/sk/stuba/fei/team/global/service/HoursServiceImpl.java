package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Hours;
import sk.stuba.fei.team.global.repository.HoursRepository;

import java.util.List;


/**
 * Created by jakubrehak on 07/05/15.
 */

@Component("hoursService")
@Transactional
public class HoursServiceImpl implements  HoursService {

    @Autowired
    HoursRepository hoursRepository;

    @Override
    public List<Hours> findByOfficeId(Long id){

        return hoursRepository.findByOfficeId(id);
    }

    @Override
    public List<Hours> findByEmployeeId(Long id){

        return hoursRepository.findByEmployeeId(id);
    }

    @Override
    public List<Hours> findByEmployeeIdAndOfficeId(Long id, Long officeid){
        return hoursRepository.findByEmployeeIdAndOfficeId(id, officeid);
    }
}
