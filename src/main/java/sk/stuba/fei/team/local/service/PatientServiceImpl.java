package sk.stuba.fei.team.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.local.domain.Patient;
import sk.stuba.fei.team.local.repository.PatientRepository;

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
}
