package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.api.domain.OpeningHoursWrapper;
import sk.stuba.fei.team.global.domain.OpeningHours;
import sk.stuba.fei.team.global.service.OfficeService;
import sk.stuba.fei.team.global.service.OpeningHoursService;

@RestController
@RequestMapping("/ws/hours")
public class OpeningHoursApi {

    @Autowired
    OpeningHoursService openingHoursService;
    @Autowired
    OfficeService officeService;

    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody OpeningHoursWrapper openingHoursWrapper) {
        OpeningHours oh = openingHoursWrapper.build(officeService);
        openingHoursService.save(oh);
        return oh.getId();
    }

}
