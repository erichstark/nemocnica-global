package sk.stuba.fei.nemocnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by matus_000 on 4.4.2015.
 */
@Entity
public class Specializacia implements Serializable {

    private int id;
    private int nazov;
    private Set<Zamestnanec> zamestnanci;
    private Set<Ambulancia> ambulancie;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public int getNazov() {
        return nazov;
    }

    public void setNazov(int nazov) {
        this.nazov = nazov;
    }


    @ManyToMany(mappedBy = "specializacie")
    public Set<Zamestnanec> getZamestnanci() {
        return zamestnanci;
    }

    public void setZamestnanci(Set<Zamestnanec> zamestnanci) {
        this.zamestnanci = zamestnanci;
    }

    @ManyToMany(mappedBy = "specializacie")
    public Set<Ambulancia> getAmbulancie() {
        return ambulancie;
    }

    public void setAmbulancie(Set<Ambulancia> ambulancie) {
        this.ambulancie = ambulancie;
    }
}
