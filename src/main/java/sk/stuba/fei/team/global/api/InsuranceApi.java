package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.service.InsuranceService;

@RestController
@RequestMapping("/ws/insurance")
public class InsuranceApi {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Insurance> all() {

        return insuranceService.findAll();
    }
}
