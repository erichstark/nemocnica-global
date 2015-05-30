package sk.stuba.fei.team.local.service;

import sk.stuba.fei.team.local.domain.Office;
import sk.stuba.fei.team.local.domain.Patient;
import sk.stuba.fei.team.local.domain.PatientOrder;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
public interface PatientOrderService {

    void save(PatientOrder order);

    List<PatientOrder> findByDateAndOffice(Date date,Office office);

    Iterable<PatientOrder> findAll();

    Iterable<PatientOrder> findByPatient( Patient patient);

    void delete(Long id);

    PatientOrder findById(Long id);

}
