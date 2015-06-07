package sk.stuba.fei.team.global.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.Order;
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
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findByDateAndOffice(Date date,Office office){
        return orderRepository.findByDateAndOffice(date,office);
    }

    @Override
    public void delete(Long id){
        orderRepository.delete(id);
    }
    @Override
    public  Iterable<Order> findAll(){

        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> findByPatient( Patient patient){
        return orderRepository.findByPatient(patient);
    }

    @Override
    public Order findById(Long id){ return orderRepository.findOne(id);}
}
