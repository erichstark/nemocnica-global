package sk.stuba.fei.team.global.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    private Long Id;
    private String firstName;
    private String lastName;
    private String prefix_title;
    private String suffix_title;
    private String phone;
    private String email;
    private Set<Office> offices;
    private Set<Specialization> specializations;

    @Id
    @GeneratedValue
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getSuffix_title() {
        return suffix_title;
    }
    public void setSuffix_title(String suffix_title) {
        this.suffix_title = suffix_title;
    }

    @Column
    public String getPrefix_title() {
        return prefix_title;
    }
    public void setPrefix_title(String prefix_title) {
        this.prefix_title = prefix_title;
    }

    @Column
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_office",
            joinColumns =
            @JoinColumn(name = "employee", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "office", referencedColumnName = "id")
    )
    public Set<Office> getOffices() {
        return offices;
    }
    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_specialization",
            joinColumns =
            @JoinColumn(name = "employee", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "specialization", referencedColumnName = "id")
    )
    public Set<Specialization> getSpecializations() {
        return specializations;
    }
    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }
}
