package sk.stuba.fei.team.global.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlRootElement
public class Insurance implements Serializable {
    private static final long serialVersionUID = -5189106543650114809L;
    private Long id;
    private String name;
    private Set<Office> offices;
    private Set<Patient> patients;
    private Date updated;
    private Boolean enabled;

    public Insurance() {
        name = "";
        offices = new HashSet<>();
        patients = new HashSet<>();
        enabled = true;
    }

    public Insurance(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "insurances")
    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insurance")
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Column(nullable = false)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}