package sk.stuba.fei.team.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.repository.PatientRepository;

import java.util.List;

@Component("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findByUsername(username);
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
    public List<Patient> findPatientByUsernameOrFirstOrSurname(String text) {
        return patientRepository.findByUsernameOrFirstnameOrSerunameCustomQuery(text);
    }
}
