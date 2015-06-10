package sk.stuba.fei.team.global.api.domain;

import org.springframework.security.core.GrantedAuthority;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.domain.Specialization;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeWrapper {
    private String password;
    private String username;
    private Set<String> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String prefix_title;
    private String suffix_title;
    private Set<Long> specializations;

    public EmployeeWrapper() {
    }

    public EmployeeWrapper(Employee employee) {
        password = employee.getPassword();
        username = employee.getUsername();
        authorities = new HashSet<>(employee.getAuthorities().size());
        authorities.addAll(employee.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        accountNonExpired = employee.isAccountNonExpired();
        accountNonLocked = employee.isAccountNonLocked();
        credentialsNonExpired = employee.isCredentialsNonExpired();
        enabled = employee.isEnabled();
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        prefix_title = employee.getPrefix_title();
        suffix_title = employee.getSuffix_title();
        specializations = new HashSet<>(employee.getSpecializations().size());
        specializations.addAll(employee.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toList()));
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<Long> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Long> specializations) {
        this.specializations = specializations;
    }
}
