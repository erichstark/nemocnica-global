package sk.stuba.fei.team.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.local.domain.Facility;
import sk.stuba.fei.team.local.repository.FacilityRepository;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
@Component("facilityiaService")
@Transactional
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Facility findOne(Long id) {
        return facilityRepository.findOne(id);
    }

    @Override
    public List<Facility> findByName(String name) {
        return facilityRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return facilityRepository.exists(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(Long id) {
        facilityRepository.delete(id);
    }
}
