package sk.stuba.fei.nemocnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.nemocnica.domain.Poistovna;
import sk.stuba.fei.nemocnica.repository.PoistovnaRepository;

import java.util.List;

/**
 * Created by pallo on 5/3/15.
 */
@Component("poistovnaService")
@Transactional
public class PoistovnaServiceImpl implements PoistovnaService {

    @Autowired
    private PoistovnaRepository poistovnaRepository;

    @Override
    public Poistovna findOne(Long id) {
        return poistovnaRepository.findOne(id);
    }

    @Override
    public List<Poistovna> findByName(String name) {
        return poistovnaRepository.findByNazovContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Poistovna> findAll() {
        return poistovnaRepository.findAll();
    }

    @Override
    public boolean exists(Long id) {
        return poistovnaRepository.exists(id);
    }

    @Override
    public void save(Poistovna poistovna) {
        poistovnaRepository.save(poistovna);
    }

    @Override
    public void delete(Long id) {
        poistovnaRepository.delete(id);
    }
}
