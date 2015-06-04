package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.repository.EmployeeRepository;


import java.util.List;

@Component("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findOne(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public List<Employee> findByFirstnameOrLastname(String text) {
        return employeeRepository.findByFirstnameOrSerunameCustomQuery(text);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return employeeRepository.exists(id);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findDoctors(String name,String surname ,String specialization, String town) {

        return employeeRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndSpecializationsContainingIgnoreCase(name, surname, specialization);
    }

    @Override
    public Employee findByUsername(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }
}
