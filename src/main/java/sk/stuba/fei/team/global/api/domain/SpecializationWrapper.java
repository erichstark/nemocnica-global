package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Specialization;

public class SpecializationWrapper {
    private Long id;
    private String name;
    private Boolean enabled;

    public SpecializationWrapper() {}

    public SpecializationWrapper(Specialization specialization) {
        this.id = specialization.getId();
        this.name = specialization.getName();
        this.enabled = specialization.getEnabled();
    }

    public Specialization build() {
        Specialization specialization = new Specialization();
        specialization.setId(id);
        specialization.setName(name);
        specialization.setEnabled(enabled);
        return specialization;
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
