package sk.stuba.fei.nemocnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.nemocnica.domain.Zamestnanec;
import sk.stuba.fei.nemocnica.repository.ZamestnanecRepository;

@Component("zamestnanecService")
@Transactional
public class ZamestnanecServiceImpl implements ZamestnanecService {

    @Autowired
    ZamestnanecRepository zamestnanecRepository;

    @Override
    public Zamestnanec findByUsername(String username) {
        return zamestnanecRepository.findByUsername(username);
    }

    @Override
    public void save(Zamestnanec zamestnanec) {
        zamestnanecRepository.save(zamestnanec);
    }
}
