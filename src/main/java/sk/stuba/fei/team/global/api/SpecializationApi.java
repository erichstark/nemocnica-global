package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.api.domain.SpecializationWrapper;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.SpecializationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ws/specialization")
public class SpecializationApi {

    @Autowired
    SpecializationService specializationService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<SpecializationWrapper> update(@RequestBody Date timestamp) {
        List<Specialization> specs = specializationService.findByTimestamp(timestamp);
        List<SpecializationWrapper> sw = new ArrayList<>(specs.size());
        specs.forEach(elt -> sw.add(new SpecializationWrapper(elt)));
        return sw;
    }

}
