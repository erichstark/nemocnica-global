package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.repository.EmployeeRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findOne(String username) {
        return employeeRepository.findOne(username);
    }

    @Override
    public List<Employee> findByFirstnameOrLastname(String text) {
        return employeeRepository.findByFirstnameOrSerunameCustomQuery(text);
    }

    @Override
    public List<Employee> findSelectedByTimestamp(Date timestamp, Set<String> usernames) {
        return employeeRepository.findByUpdatedGreaterThanAndUsernameIn(timestamp, usernames);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean exists(String username) {
        return employeeRepository.exists(username);
    }

    @Override
    public void delete(String username) {
        employeeRepository.delete(username);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findDoctors(String name,String surname) {

        return employeeRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(name, surname);
    }

}
