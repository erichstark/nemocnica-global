package sk.stuba.fei.nemocnica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by matus_000 on 4.4.2015.
 */
@Entity
public class Zamestnanec implements Serializable {

    private int id;
    private String username;
    private String password;
    private String role;
    private Set<Ambulancia> ambulancie;
    private Set<Specializacia> specializacie;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "zamestnanec_ambulancia",
            joinColumns =
            @JoinColumn(name = "zamestnanec", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "ambulancia", referencedColumnName = "id")
    )
    public Set<Ambulancia> getAmbulancie() {
        return ambulancie;
    }

    public void setAmbulancie(Set<Ambulancia> ambulancie) {
        this.ambulancie = ambulancie;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "zamestnanec_specializacia",
            joinColumns =
            @JoinColumn(name = "zamestnanec", referencedColumnName = "id"),
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
