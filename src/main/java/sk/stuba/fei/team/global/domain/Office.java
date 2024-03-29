package sk.stuba.fei.team.global.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@XmlRootElement
public class Office implements Serializable {

    private static final long serialVersionUID = 563004025850191193L;
    private Long id;
    private String name;
    private Facility facility;
    private String phone;
    private Set<Employee> employees;
    private Set<Insurance> insurances;
    private Set<Specialization> specializations;
    private Set<OpeningHours> hours;
    private Set<Appointment> appointments;
    private Boolean enabled;

    public Office() {
        name = "";
        phone = "";
        employees = new HashSet<>();
        insurances = new HashSet<>();
        specializations = new HashSet<>();
        hours = new HashSet<>();
        appointments = new HashSet<>();
        enabled = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Column(nullable = false)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
