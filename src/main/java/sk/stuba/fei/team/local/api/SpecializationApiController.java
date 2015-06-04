package sk.stuba.fei.team.local.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.local.domain.Specialization;
import sk.stuba.fei.team.local.service.SpecializationService;

@RestController
@RequestMapping("/ws/specialization")
public class SpecializationApiController {

    @Autowired
    SpecializationService specializationService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Specialization> all() {

        return specializationService.findAll();
    }

}
