package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findByUsername(String username);

    Employee findOne(Long id);

    List<Employee> findByFirstnameOrLastname(String text);

    Iterable<Employee> findAll();

    boolean exists(Long id);

    void save(Employee employee);

    List<Employee> findDoctors(String name,String surname);

    void delete(Long id);

}
