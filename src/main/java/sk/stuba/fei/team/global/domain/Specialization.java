package sk.stuba.fei.team.global.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Specialization implements Serializable {

    private Long id;
    private String name;
    private Set<Office> offices;
    private Set<Employee> employees;

    public Specialization() {}

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
}
