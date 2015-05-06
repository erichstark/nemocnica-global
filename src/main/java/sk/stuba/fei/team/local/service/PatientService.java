package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Patient;

public interface PatientService {
    Patient findByUsername(String username);

    void save(Patient patient);
}
