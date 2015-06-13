package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Employee;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface EmployeeService {

    Employee findOne(String username);

    List<Employee> findSelectedByTimestamp(Date timestamp, Set<String> usernames);

    List<Employee> findByFirstnameOrLastname(String text);

    Iterable<Employee> findAll();

    boolean exists(String username);

    void save(Employee employee);

    List<Employee> findDoctors(String name,String surname);

    void delete(String username);

}
