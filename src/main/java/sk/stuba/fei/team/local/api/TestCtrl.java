package sk.stuba.fei.team.local.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Facility;
import sk.stuba.fei.team.local.domain.Office;
import sk.stuba.fei.team.local.service.FacilityService;
import sk.stuba.fei.team.local.service.OfficeService;

@RestController
@RequestMapping("/ws")
public class TestCtrl {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private OfficeService officeService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello\n";
    }

    @RequestMapping(value = "/{fid}/saveOffice", method = RequestMethod.POST)
    public String save(@RequestBody Office office, @PathVariable Long fid) {

        Facility facility = facilityService.findOne(fid);
        office.setFacility(facility);

        officeService.save(office);

        return "som divny";
    }
}
