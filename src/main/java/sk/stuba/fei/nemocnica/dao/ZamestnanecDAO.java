package sk.stuba.fei.nemocnica.dao;

import sk.stuba.fei.nemocnica.model.Zamestnanec;

import java.util.List;

/**
 * Created by matus_000 on 7.4.2015.
 */
public interface ZamestnanecDAO {
    List getAll();

    Zamestnanec getById(int id);

    Zamestnanec getByUsername(String username);

    void createOrUpdate(Zamestnanec zamestnanec);
}
