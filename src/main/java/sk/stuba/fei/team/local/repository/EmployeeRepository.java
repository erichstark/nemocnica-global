package sk.stuba.fei.team.local.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.local.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

}
