package sk.stuba.fei.team.global.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.repository.OrderRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
@Component("patientOrderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Appointment appointment) {
        orderRepository.save(appointment);
    }

    @Override
    public List<Appointment> findByDateAndOffice(Date date,Office office){
        return orderRepository.findByDateAndOffice(date,office);
    }

    @Override
    public void delete(Long id){
        orderRepository.delete(id);
    }
    @Override
    public  Iterable<Appointment> findAll(){

        return orderRepository.findAll();
    }

    @Override
    public Iterable<Appointment> findByPatient( Patient patient){
        return orderRepository.findByPatient(patient);
    }

    @Override
    public Appointment findById(Long id){ return orderRepository.findOne(id);}
}
