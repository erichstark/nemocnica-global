package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.SpecializationService;

import java.util.Date;

@RestController
@RequestMapping("/ws/specialization")
public class SpecializationApi {

    @Autowired
    SpecializationService specializationService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Iterable<Specialization> update(@RequestBody Date timestamp) {
        return specializationService.findByTimestamp(timestamp);
    }

}
