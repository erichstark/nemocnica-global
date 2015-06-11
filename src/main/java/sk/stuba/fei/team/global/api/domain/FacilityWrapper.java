package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Facility;
import sk.stuba.fei.team.global.service.FacilityService;

public class FacilityWrapper {
    private Long id;
    private String name;
    private String streetAndNumber;
    private String city;
    private String zip;
    private Boolean enabled;

    public FacilityWrapper() {
    }

    public FacilityWrapper(Facility facility) {
        id = facility.getId();
        name = facility.getName();
        streetAndNumber = facility.getStreetAndNumber();
        city = facility.getCity();
        zip = facility.getZip();
        enabled = facility.getEnabled();
    }

    public Facility build(FacilityService facilityService) {
        Facility f = new Facility();
        f.setId(id);
        f.setName(name);
        f.setStreetAndNumber(streetAndNumber);
        f.setCity(city);
        f.setZip(zip);
        f.setEnabled(enabled);
        Facility oldFacility = facilityService.findOne(id);
        if (oldFacility != null) f.getOffices().addAll(oldFacility.getOffices());
        return f;
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

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
