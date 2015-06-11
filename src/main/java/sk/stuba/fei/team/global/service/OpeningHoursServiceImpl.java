package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.OpeningHours;
import sk.stuba.fei.team.global.repository.OpeningHoursRepository;

import java.util.List;


/**
 * Created by jakubrehak on 07/05/15.
 */

@Component("hoursService")
@Transactional
public class OpeningHoursServiceImpl implements OpeningHoursService {

    @Autowired
    OpeningHoursRepository openingHoursRepository;

    @Override
    public List<OpeningHours> findByOfficeId(Long id){

        return openingHoursRepository.findByOfficeId(id);
    }

    @Override
    public void save(OpeningHours openingHours) {
        openingHoursRepository.save(openingHours);
    }
}
