package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Facility;
import sk.stuba.fei.team.global.service.FacilityService;

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
