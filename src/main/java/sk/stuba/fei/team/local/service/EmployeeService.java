package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findByUsername(String username);

    Employee findOne(Long id);

    List<Employee> findByFirstnameOrLastname(String text);

    Iterable<Employee> findAll();

    boolean exists(Long id);

    void save(Employee employee);

    void delete(Long id);
    
    List<Employee> findDoctors(String name,String surname ,String specialization, String town);

    void delete(Long id);

}
