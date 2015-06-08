package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
public interface OrderService {

    void save(Appointment appointment);

    List<Appointment> findByDateAndOffice(Date date,Office office);

    Iterable<Appointment> findAll();

    Iterable<Appointment> findByPatient( Patient patient);

    void delete(Long id);

    Appointment findById(Long id);

}
