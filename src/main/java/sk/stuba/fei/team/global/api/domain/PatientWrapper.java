package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.ArrayList;
import java.util.List;

public class PatientWrapper {
    private String username;
    private String password;
    private String firstName;
    private String surname;
    private String phone;
    private String email;
    private String prefix_title;
    private String suffix_title;
    private Long insurance;
    private boolean enabled;

    public PatientWrapper() {
    }

    public PatientWrapper(Patient patient) {
        username = patient.getUsername();
        password = patient.getPassword();
        firstName = patient.getFirstName();
        surname = patient.getSurname();
        phone = patient.getPhone();
        email = patient.getEmail();
        prefix_title = patient.getPrefix_title();
        suffix_title = patient.getSuffix_title();
        insurance = patient.getInsurance().getId();
        enabled = patient.isEnabled();
    }

    public Patient build(PatientService patientService, InsuranceService insuranceService) {
        Patient p = new Patient();
        p.setUsername(username);
        p.setPassword(password);
        p.setFirstName(firstName);
        p.setAccountNonExpired(true);
        p.setAccountNonLocked(true);
        p.setCredentialsNonExpired(true);
        p.setSurname(surname);
        p.setPhone(phone);
        p.setEmail(email);
        p.setEnabled(enabled);
        p.setPrefix_title(prefix_title);
        p.setSuffix_title(suffix_title);
        p.setInsurance(insuranceService.findOne(insurance));
        Patient pold = patientService.findOne(username);
        if (pold != null) {
            p.setStringAuthorities(pold.getStringAuthorities());
            p.getAppointments().addAll(pold.getAppointments());
        } else {
            List<String> auths = new ArrayList<>(1);
            auths.add("USER");
            p.setStringAuthorities(auths);
        }
        return p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
