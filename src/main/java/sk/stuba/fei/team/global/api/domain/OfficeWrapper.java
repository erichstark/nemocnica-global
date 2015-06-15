package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OfficeWrapper {

    private Long id;
    private String name;
    private Long facility;
    private Set<String> employees;
    private Set<Long> insurances;
    private Set<Long> specializations;
    private Boolean enabled;

    public OfficeWrapper() {
    }

    public OfficeWrapper(Office office) {
        id = office.getId();
        name = office.getName();
        facility = office.getFacility().getId();
        employees = new HashSet<>(office.getEmployees().size());
        employees.addAll(office.getEmployees().stream().map(Employee::getUsername).collect(Collectors.toList()));
        insurances = new HashSet<>(office.getInsurances().size());
        insurances.addAll(office.getInsurances().stream().map(Insurance::getId).collect(Collectors.toList()));
        specializations = new HashSet<>(office.getSpecializations().size());
        specializations.addAll(office.getSpecializations().stream().map(Specialization::getId).collect(Collectors.toList()));
        enabled = office.getEnabled();
    }

    public Office build(OfficeService officeService, FacilityService facilityService, EmployeeService employeeService, InsuranceService insuranceService, SpecializationService specializationService) {
        Office office = new Office();
        office.setId(id);
        office.setName(name);
        office.setFacility(facilityService.findOne(facility));
        office.getEmployees().addAll(employees.stream().map(employeeService::findOne).collect(Collectors.toSet()));
        office.getInsurances().addAll(insurances.stream().map(insuranceService::findOne).collect(Collectors.toSet()));
        office.getSpecializations().addAll(specializations.stream().map(specializationService::findOne).collect(Collectors.toSet()));
        if(id!=null && id!=0) {
            Office oldOffice = officeService.findOne(id);
            if (oldOffice != null) {
                office.getHours().addAll(oldOffice.getHours());
                office.getAppointments().addAll(oldOffice.getAppointments());
            }
        }
        office.setEnabled(enabled);
        return office;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFacility() {
        return facility;
    }

    public void setFacility(Long facility) {
        this.facility = facility;
    }

    public Set<String> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<String> employees) {
        this.employees = employees;
    }

    public Set<Long> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Long> insurances) {
        this.insurances = insurances;
    }

    public Set<Long> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Long> specializations) {
        this.specializations = specializations;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
