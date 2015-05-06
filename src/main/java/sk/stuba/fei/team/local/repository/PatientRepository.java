package sk.stuba.fei.team.local.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.team.local.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, String> {

    Patient findByUsername(String username);

}