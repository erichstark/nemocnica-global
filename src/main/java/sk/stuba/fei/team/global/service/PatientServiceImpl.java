package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.VerificationToken;
import sk.stuba.fei.team.global.repository.PatientRepository;
import sk.stuba.fei.team.global.repository.VerificationTokenRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findOne(username);
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findOne(String username) {
        return patientRepository.findOne(username);
    }

    @Override
    public Iterable<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public boolean exists(String username) {
        return patientRepository.exists(username);
    }

    @Override
    public void delete(String username) {
        patientRepository.delete(username);
    }

    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

    @Override
    public void createVerificationToken(Patient patient, String token) {
        VerificationToken vt = new VerificationToken(token, patient);
        tokenRepository.save(vt);
    }

    @Override
    public List<Patient> findPatientByUsernameOrFirstOrSurname(String text) {
        return patientRepository.findByUsernameOrFirstnameOrSerunameCustomQuery(text);
    }

    @Override
    public List<Patient> findSelectedByTimestamp(Date timestamp, Set<String> usernames) {
        return patientRepository.findByUpdatedGreaterThanAndUsernameIn(timestamp, usernames);
    }

    @Override
    public List<Patient> findBySurNameOrEmail(String searchTerm) {
        return patientRepository.findBySurnameContainingOrEmailContainingAllIgnoreCase(searchTerm, searchTerm);
    }

}
