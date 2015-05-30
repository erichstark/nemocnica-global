package sk.stuba.fei.team.local.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sk.stuba.fei.team.local.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.firstName like %:text% or e.lastName like %:text%")
    List<Employee> findByFirstnameOrSerunameCustomQuery(@Param("text") String text);

    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    List<Employee> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseAndSpecializationsContainingIgnoreCase(String name,String surname ,String specialization);



}
