package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Employee;

/**
 * Created by loucher on 29.4.2015.
 */
public interface EmployeeService {
    Employee findByUsername(String username);

    void save(Employee employee);
}
