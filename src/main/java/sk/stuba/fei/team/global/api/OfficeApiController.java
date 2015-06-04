package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Facility;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.service.FacilityService;
import sk.stuba.fei.team.global.service.OfficeService;

@RestController
@RequestMapping("/ws")
public class OfficeApiController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private OfficeService officeService;

    @RequestMapping(value = "/facility/{fid}/office", method = RequestMethod.POST)
    public Long saveOffice(@RequestBody Office office, @PathVariable Long fid) {

        Facility facility = facilityService.findOne(fid);
        office.setFacility(facility);

        officeService.save(office);

        return office.getId();
    }

    @RequestMapping(value = "/facility/{fid}/office", method = RequestMethod.GET)
    public Iterable<Office> facilityOffices(@PathVariable Long fid) {
        Facility facility = facilityService.findOne(fid);

        return facility.getOffices();
    }

    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public Iterable<Office> officesAll() {
        return
                officeService.findAll();
    }
}
