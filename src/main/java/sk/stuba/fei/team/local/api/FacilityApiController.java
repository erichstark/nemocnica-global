package sk.stuba.fei.team.local.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Facility;
import sk.stuba.fei.team.local.service.FacilityService;

@RestController
@RequestMapping("/ws/facility")
public class FacilityApiController {

    @Autowired
    private FacilityService facilityService;

    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody Facility facility) {

        facilityService.save(facility);

        return facility.getId();
    }


}
