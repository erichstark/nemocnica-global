package sk.stuba.fei.nemocnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.nemocnica.domain.Zariadenie;
import sk.stuba.fei.nemocnica.repository.ZariadenieRepository;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
@Component("zariadenieiaService")
@Transactional
public class ZariadenieServiceImpl implements ZariadenieService {

    @Autowired
    private ZariadenieRepository zariadenieRepository;

    @Override
    public Zariadenie findOne(Long id) {
        return zariadenieRepository.findOne(id);
    }

    @Override
    public List<Zariadenie> findByName(String name) {
        return zariadenieRepository.findByNazovContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Zariadenie> findAll() {
        return zariadenieRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return zariadenieRepository.exists(id);
    }

    @Override
    public void save(Zariadenie zariadenie) {
        zariadenieRepository.save(zariadenie);
    }

    @Override
    public void delete(Long id) {
        zariadenieRepository.delete(id);
    }
}
