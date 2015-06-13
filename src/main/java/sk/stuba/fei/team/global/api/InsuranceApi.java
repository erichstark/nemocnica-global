package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.api.domain.InsuranceWrapper;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.service.InsuranceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ws/insurance")
public class InsuranceApi {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<InsuranceWrapper> update(@RequestBody Date timestamp) {
        List<Insurance> ins = insuranceService.findByTimestamp(timestamp);
        List<InsuranceWrapper> iw = new ArrayList<>(ins.size());
        ins.forEach(elt -> iw.add(new InsuranceWrapper(elt)));
        return iw;
    }
}
