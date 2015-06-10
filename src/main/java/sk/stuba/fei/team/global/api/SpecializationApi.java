package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.SpecializationService;

@RestController
@RequestMapping("/ws/specialization")
public class SpecializationApi {

    @Autowired
    SpecializationService specializationService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Specialization> all() {

        return specializationService.findAll();
    }

}
