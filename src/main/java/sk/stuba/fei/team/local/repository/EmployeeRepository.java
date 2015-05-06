package sk.stuba.fei.team.local.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.local.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Employee findByUsername(String username);

}
