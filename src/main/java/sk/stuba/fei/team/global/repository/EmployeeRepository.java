package sk.stuba.fei.team.global.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sk.stuba.fei.team.global.domain.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("select e from Employee e where e.firstName like %:text% or e.lastName like %:text%")
    List<Employee> findByFirstnameOrSerunameCustomQuery(@Param("text") String text);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    List<Employee> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String name,String surname);

    List<Employee> findByUpdatedGreaterThanAndUsernameIn(Date timestamp,Collection<String> usernames);

    Employee findByFirstName(String firstName);

}
