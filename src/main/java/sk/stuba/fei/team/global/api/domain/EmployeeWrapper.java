package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.EmployeeService;
import sk.stuba.fei.team.global.service.OfficeService;
import sk.stuba.fei.team.global.service.SpecializationService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeWrapper {
    private String password;
    private String username;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String prefix_title;
    private String suffix_title;
    private Set<Long> specializations;
    private Set<Long> offices;

    public EmployeeWrapper() {
    }

    public EmployeeWrapper(Employee employee) {
        password = employee.getPassword();
        username = employee.getUsername();
        enabled = employee.isEnabled();
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        prefix_title = employee.getPrefix_title();
        suffix_title = employee.getSuffix_title();
        specializations = new HashSet<>(employee.getSpecializations().size());
        specializations.addAll(employee.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toSet()));
        offices = new HashSet<>(employee.getOffices().size());
        offices.addAll(employee.getOffices().stream().map(Office::getId).collect(Collectors.toSet()));
    }

    public Employee build(SpecializationService specializationService, EmployeeService employeeService, OfficeService officeService) {
        Employee employee = new Employee();
        employee.setPassword(password);
        employee.setUsername(username);
        employee.setEnabled(enabled);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPrefix_title(prefix_title);
        employee.setSuffix_title(suffix_title);
        employee.getSpecializations().addAll(this.specializations.stream().map(specializationService::findOne).collect(Collectors.toSet()));
        employee.getOffices().addAll(this.offices.stream().map(officeService::findOne).collect(Collectors.toSet()));
        Employee oldEmployee = employeeService.findOne(username);
        if (oldEmployee != null) {
            employee.getOffices().addAll(oldEmployee.getOffices());
            employee.getSpecializations().addAll(oldEmployee.getSpecializations());
        }
        return employee;
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

    public Set<Long> getOffices() {
        return offices;
    }

    public void setOffices(Set<Long> offices) {
        this.offices = offices;
    }
}
