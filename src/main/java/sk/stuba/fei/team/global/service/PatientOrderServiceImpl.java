package sk.stuba.fei.team.global.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.PatientOrder;
import sk.stuba.fei.team.global.repository.PatientOrderRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
@Component("patientOrderService")
@Transactional
public class PatientOrderServiceImpl implements PatientOrderService {

    @Autowired
    private PatientOrderRepository orderRepository;

    @Override
    public void save(PatientOrder order) {
        orderRepository.save(order);
    }

    @Override
    public List<PatientOrder> findByDateAndOffice(Date date,Office office){
        return orderRepository.findByDateAndOffice(date,office);
    }

    @Override
    public void delete(Long id){
        orderRepository.delete(id);
    }
    @Override
    public  Iterable<PatientOrder> findAll(){

        return orderRepository.findAll();
    }

    @Override
    public Iterable<PatientOrder> findByPatient( Patient patient){
        return orderRepository.findByPatient(patient);
    }

    @Override
    public PatientOrder findById(Long id){ return orderRepository.findOne(id);}
}
