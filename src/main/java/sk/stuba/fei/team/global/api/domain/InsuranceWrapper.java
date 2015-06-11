package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.service.InsuranceService;

public class InsuranceWrapper {
    private Long id;
    private String name;
    private Boolean enabled;

    public InsuranceWrapper() {
    }

    public InsuranceWrapper(Insurance insurance) {
        id = insurance.getId();
        name = insurance.getName();
        enabled = insurance.getEnabled();
    }

    public Insurance build(InsuranceService insuranceService) {
        Insurance insurance = new Insurance();
        insurance.setId(id);
        insurance.setName(name);
        insurance.setEnabled(enabled);
        Insurance oldInsurance = insuranceService.findOne(id);
        if (oldInsurance != null) {
            insurance.getOffices().addAll(oldInsurance.getOffices());
            insurance.getPatients().addAll(oldInsurance.getPatients());
        }
        return insurance;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
