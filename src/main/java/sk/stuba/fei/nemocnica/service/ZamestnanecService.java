package sk.stuba.fei.nemocnica.service;

import sk.stuba.fei.nemocnica.domain.Zamestnanec;

/**
 * Created by loucher on 29.4.2015.
 */
public interface ZamestnanecService {
    Zamestnanec findByUsername(String username);

    void save(Zamestnanec zamestnanec);
}
