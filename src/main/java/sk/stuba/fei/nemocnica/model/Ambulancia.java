package sk.stuba.fei.nemocnica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by matus_000 on 4.4.2015.
 */
@Entity
public class Ambulancia implements Serializable {

    private int id;
    private String name;
    private Zariadenie zariadenie;
    private Set<Zamestnanec> zamestnanci;
    private Set<Specializacia> specializacie;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "ambulancie")
    public Set<Zamestnanec> getZamestnanci() {
        return zamestnanci;
    }

    public void setZamestnanci(Set<Zamestnanec> zamestnanci) {
        this.zamestnanci = zamestnanci;
    }

    @ManyToOne
    @JoinColumn(name = "zariadenie", nullable = false)
    public Zariadenie getZariadenie() {
        return zariadenie;
    }

    public void setZariadenie(Zariadenie zariadenie) {
        this.zariadenie = zariadenie;
    }

    @ManyToMany
    @JoinTable(
            name = "ambulancia_specializacia",
            joinColumns =
            @JoinColumn(name = "ambulancia", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "specializacia", referencedColumnName = "id")
    )
    public Set<Specializacia> getSpecializacie() {
        return specializacie;
    }

    public void setSpecializacie(Set<Specializacia> specializacie) {
        this.specializacie = specializacie;
    }
}
