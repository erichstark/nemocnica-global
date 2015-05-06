package sk.stuba.fei.team.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.local.domain.Insurance;
import sk.stuba.fei.team.local.repository.InsuranceRepository;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
@Component("insuranceService")
@Transactional
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public Insurance findOne(Long id) {
        return insuranceRepository.findOne(id);
    }

    @Override
    public List<Insurance> findByName(String name) {
        return insuranceRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Insurance> findAll() {
        return insuranceRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return insuranceRepository.exists(id);
    }

    @Override
    public void save(Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    @Override
    public void delete(Long id) {
        insuranceRepository.delete(id);
    }
}
