package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.VerificationToken;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PatientService {
    Patient findByUsername(String username);

    void save(Patient patient);

    Patient findOne(String username);

    Iterable<Patient> findAll();

    boolean exists(String username);

    void delete(String username);

    void createVerificationToken(Patient patient, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    List<Patient> findPatientByUsernameOrFirstOrSurname(String text);

    List<Patient> findSelectedByTimestamp(Date timestamp, Set<String> usernames);

    List<Patient> findBySurNameOrEmail(String searchTerm);
}
