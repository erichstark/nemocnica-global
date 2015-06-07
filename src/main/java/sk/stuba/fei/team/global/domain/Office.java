package sk.stuba.fei.team.global.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@Entity
@XmlRootElement
public class Office implements Serializable {

    private Long id;
    private String name;
    private Facility facility;
    private Set<Employee> employees;
    private Set<Insurance> insurances;
    private Set<Specialization> specializations;
    private Set<OpeningHours> hours;
    private Set<Order> orders;


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

    @ManyToMany(mappedBy = "offices")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @ManyToOne
    @JoinColumn(name = "facility", nullable = false)
    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "office_insurance",
            joinColumns =
            @JoinColumn(name = "office", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "insurance", referencedColumnName = "id")
    )
    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "office_specialization",
            joinColumns =
            @JoinColumn(name = "office", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "specialization", referencedColumnName = "id")
    )
    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    public Set<OpeningHours> getHours() {
        return hours;
    }

    public void setHours(Set<OpeningHours> hours) {
        this.hours = hours;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "office")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
