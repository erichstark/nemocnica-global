package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findOne(Long id);

    List<Employee> findByLastName(String lastName);

    Iterable<Employee> findAll();

    boolean exists(Long id);

    void save(Employee employee);

    void delete(Long id);

}
