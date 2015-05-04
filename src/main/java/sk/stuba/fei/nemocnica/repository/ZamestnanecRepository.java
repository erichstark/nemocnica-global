package sk.stuba.fei.nemocnica.repository;

import org.springframework.data.repository.CrudRepository;
import sk.stuba.fei.nemocnica.domain.Zamestnanec;

public interface ZamestnanecRepository extends CrudRepository<Zamestnanec, String> {

    Zamestnanec findByUsername(String username);

}
