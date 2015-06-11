package sk.stuba.fei.team.global.api.domain;

import org.springframework.security.core.GrantedAuthority;
import sk.stuba.fei.team.global.domain.Patient;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PatientWrapper {
    private String password;
    private String username;
    private Set<String> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String surname;
    private String phone;
    private String email;
    private String prefix_title;
    private String suffix_title;
    private Long insurance;

    public PatientWrapper() {
    }

    public PatientWrapper(Patient patient) {
        password = patient.getPassword();
        username = patient.getUsername();
        authorities = new HashSet<>(patient.getAuthorities().size());
        authorities.addAll(patient.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        accountNonExpired = patient.isAccountNonExpired();
        accountNonLocked = patient.isAccountNonLocked();
        credentialsNonExpired = patient.isCredentialsNonExpired();
        enabled = patient.isEnabled();
        firstName = patient.getFirstName();
        surname = patient.getSurname();
        phone = patient.getPhone();
        email = patient.getEmail();
        prefix_title = patient.getPrefix_title();
        suffix_title = patient.getSuffix_title();
        insurance = patient.getInsurance().getId();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
}
