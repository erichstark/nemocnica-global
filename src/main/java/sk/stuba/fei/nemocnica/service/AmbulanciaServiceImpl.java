package sk.stuba.fei.nemocnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.nemocnica.domain.Ambulancia;
import sk.stuba.fei.nemocnica.repository.AmbulanciaRepository;

import java.util.List;

/**
 * Created by pallo on 5/2/15.
 */
@Component("ambulanciaService")
@Transactional
public class AmbulanciaServiceImpl implements AmbulanciaService {

    @Autowired
    private AmbulanciaRepository ambulanciaRepository;

    @Override
    public Ambulancia findOne(Long id) {
        return ambulanciaRepository.findOne(id);
    }

    @Override
    public List<Ambulancia> findByName(String name) {
        return ambulanciaRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Ambulancia> findAll() {
        return ambulanciaRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return ambulanciaRepository.exists(id);
    }

    @Override
    public void save(Ambulancia ambulancia) {
        ambulanciaRepository.save(ambulancia);
    }

    @Override
    public void delete(Long id) {
        ambulanciaRepository.delete(id);
    }
}
