package sk.stuba.fei.nemocnica.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import sk.stuba.fei.nemocnica.model.Zamestnanec;

import java.util.List;

/**
 * Created by matus_000 on 7.4.2015.
 */
public class ZamestnanecDAOImpl implements ZamestnanecDAO {

    private static final String BY_USERNAME = "FROM Zamestnanec Z WHERE username = :username";

    private SessionFactory sessionFactory;

    public ZamestnanecDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Zamestnanec> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Zamestnanec.class).list();
    }

    @Override
    @Transactional
    public Zamestnanec getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (Zamestnanec) session.get(Zamestnanec.class, id);
    }

    @Override
    @Transactional
    public Zamestnanec getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(BY_USERNAME);
        query.setParameter("username", username);
        List list = query.list();
        if (list.size() == 0) {
            return null;
        } else {
            return (Zamestnanec) list.get(0);
        }
    }

    @Override
    @Transactional
    public void createOrUpdate(Zamestnanec zamestnanec) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(zamestnanec);
    }
}
