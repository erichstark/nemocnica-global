package sk.stuba.fei.nemocnica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by matus_000 on 4.4.2015.
 */
@Entity
public class Zariadenie implements Serializable {

    private int id;
    private String nazov;
    private Set<Ambulancia> ambulancie;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zariadenie")
    public Set<Ambulancia> getAmbulancie() {
        return ambulancie;
    }

    public void setAmbulancie(Set<Ambulancia> ambulancie) {
        this.ambulancie = ambulancie;
    }
}
