package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Specialization;

import java.util.Collection;
import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
public interface OfficeService {

    Office findOne(Long id);

    List<Office> findByName(String name);

    Iterable<Office> findAll();

    boolean exists(Long id);

    void save(Office office);

    void delete(Long id);

    List<Office> findByEmployeesInAndSpecializationsIn(Collection<Employee> employees, Collection<Specialization> specialization);

    List<Office> findBySpecializationsIn(Collection<Specialization> specializations);

}
