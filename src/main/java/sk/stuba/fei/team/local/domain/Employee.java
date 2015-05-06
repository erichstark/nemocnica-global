package sk.stuba.fei.team.local.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    private Long Id;
    private String firstName;
    private String lastName;
    private String prefix_title;
    private String suffix_title;
    private Set<Office> offices;
    private List<String> specializations;

    @Id
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

    @ElementCollection
    public List<String> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<String> specializations) {
        this.specializations = specializations;
    }

}
