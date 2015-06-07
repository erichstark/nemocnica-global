package sk.stuba.fei.team.global.service;

import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 10/05/15.
 */
public interface OrderService {

    void save(Order order);

    List<Order> findByDateAndOffice(Date date,Office office);

    Iterable<Order> findAll();

    Iterable<Order> findByPatient( Patient patient);

    void delete(Long id);

    Order findById(Long id);

}
