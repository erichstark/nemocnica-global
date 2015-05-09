package sk.stuba.fei.team.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.local.domain.Specialization;
import sk.stuba.fei.team.local.repository.SpecializationRepository;

import java.util.List;

/**
 * Created by pallo on 5/7/15.
 */
@Component("specializationService")
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public Specialization findOne(Long id) {
        return specializationRepository.findOne(id);
    }

    @Override
    public List<Specialization> findByName(String name) {
        return specializationRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return specializationRepository.exists(id);
    }

    @Override
    public void save(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    @Override
    public void delete(Long id) {
        specializationRepository.delete(id);
    }
}
