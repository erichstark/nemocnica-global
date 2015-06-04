package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Patient;

import java.util.List;

public interface PatientService {
    Patient findByUsername(String username);

    void save(Patient patient);

    Patient findOne(String username);

    Iterable<Patient> findAll();

    boolean exists(String username);

    void delete(String username);

    List<Patient> findPatientByUsernameOrFirstOrSurname(String text);
}
