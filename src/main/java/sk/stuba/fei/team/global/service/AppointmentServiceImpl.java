package sk.stuba.fei.team.global.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.repository.AppointmentRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
@Component
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findByDateAndOffice(Date date,Office office){
        return appointmentRepository.findByDateAndOffice(date,office);
    }

    @Override
    public List<Appointment> findByTimestampAndOffice(Date timestamp, Office office) {
        return appointmentRepository.findByUpdatedGreaterThanAndOffice(timestamp, office);
    }

    @Override
    public void delete(Long id){
        appointmentRepository.delete(id);
    }
    @Override
    public  Iterable<Appointment> findAll(){

        return appointmentRepository.findAll();
    }

    @Override
    public Iterable<Appointment> findByPatient( Patient patient){
        return appointmentRepository.findByPatient(patient);
    }

    @Override
    public Appointment findById(Long id){ return appointmentRepository.findOne(id);}
}
