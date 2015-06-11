package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.api.domain.FacilityWrapper;
import sk.stuba.fei.team.global.domain.Facility;
import sk.stuba.fei.team.global.service.FacilityService;

@RestController
@RequestMapping("/ws/facility")
public class FacilityApi {

    @Autowired
    private FacilityService facilityService;

    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody FacilityWrapper facilityWrapper) {
        Facility f = facilityWrapper.build(facilityService);
        facilityService.save(f);

        return f.getId();
    }

}
