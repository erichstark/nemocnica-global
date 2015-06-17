package sk.stuba.fei.team.global.controller.patient;

import org.springframework.security.core.GrantedAuthority;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.domain.Insurance;

import java.util.Date;
import java.util.List;

/**
 * Created by jakubrehak on 17/06/15.
 */
public class PatientForm {

    private String firstName;
    private String surname;
    private String phone;
    private String email;
    private String prefix_title;
    private String suffix_title;
    private Long insurance;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrefix_title() {
        return prefix_title;
    }

    public void setPrefix_title(String prefix_title) {
        this.prefix_title = prefix_title;
    }

    public String getSuffix_title() {
        return suffix_title;
    }

    public void setSuffix_title(String suffix_title) {
        this.suffix_title = suffix_title;
    }

    public Long getInsurance() {
        return insurance;
    }

    public void setInsurance(Long insurance) {
        this.insurance = insurance;
    }
}
