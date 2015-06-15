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
public class Employee implements Serializable {

    private static final long serialVersionUID = 6319333400005244129L;
    private String password;
    private String username;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String prefix_title;
    private String suffix_title;
    private Set<Office> offices;
    private Set<Specialization> specializations;
    private Date updated;

    public Employee() {
        password = "";
        username = "";
        enabled = true;
        firstName = "";
        lastName = "";
        prefix_title = "";
        suffix_title = "";
        offices = new HashSet<Office>();
        specializations = new HashSet<Specialization>();
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(columnDefinition = "VARCHAR(256) DEFAULT ''")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(columnDefinition = "VARCHAR(256) DEFAULT ''")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(columnDefinition = "VARCHAR(256) DEFAULT ''")
    public String getSuffix_title() {
        return suffix_title;
    }

    public void setSuffix_title(String suffix_title) {
        this.suffix_title = suffix_title;
    }

    @Column(columnDefinition = "VARCHAR(256) DEFAULT ''")
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
            @JoinColumn(name = "employee", referencedColumnName = "username"),
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
            @JoinColumn(name = "employee", referencedColumnName = "username"),
            inverseJoinColumns =
            @JoinColumn(name = "specialization", referencedColumnName = "id")
    )
    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    public java.util.Date getUpdated() {
        return updated;
    }

    public void setUpdated(java.util.Date updated) {
        this.updated = updated;
    }

    @Transient
    public String getFullName() {
        return prefix_title + " " + firstName + " " + lastName + ", " + suffix_title;
    }
}
