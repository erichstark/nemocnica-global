package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.repository.OfficeRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
@Component("officeService")
@Transactional
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Office findOne(Long id) {
        return officeRepository.findOne(id);
    }

    @Override
    public List<Office> findByName(String name) {
        return officeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return officeRepository.exists(id);
    }

    @Override
    public void save(Office office) {
        officeRepository.save(office);
    }

    @Override
    public void delete(Long id) {
        officeRepository.delete(id);
    }

    @Override
    public List<Office> findByEmployeesInAndSpecializationsIn(Collection<Employee> employees, Collection<Specialization> specialization)
    {return officeRepository.findByEmployeesInAndSpecializationsIn(employees, specialization);}

    @Override
    public List<Office> findBySpecializationsIn(Collection<Specialization> specializations){
        return officeRepository.findBySpecializationsIn(specializations);
    }

}
