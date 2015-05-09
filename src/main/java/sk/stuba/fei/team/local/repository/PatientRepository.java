package sk.stuba.fei.team.local.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sk.stuba.fei.team.local.domain.Patient;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, String> {

    Patient findByUsername(String username);

    @Query("select p from Patient p where p.username like %:text% or p.firstName like %:text% or p.surname like %:text%")
    List<Patient> findByUsernameOrFirstnameOrSerunameCustomQuery(@Param("text") String text);
}