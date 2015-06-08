package sk.stuba.fei.team.global.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@XmlRootElement
public class Specialization implements Serializable {

    private Long id;
    private String name;
    private Set<Office> offices;
    private Set<Employee> employees;
    private Date updated;
    private Boolean enabled;

    public Specialization() {
    }

    public Specialization(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "specializations")
    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    @ManyToMany(mappedBy = "specializations")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false)
    public java.util.Date getUpdated() {
        return updated;
    }

    public void setUpdated(java.util.Date updated) {
        this.updated = updated;
    }

    @PrePersist
    protected void onCreate() {
        updated = new java.util.Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new java.util.Date();
    }

    @Column(nullable = false)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
