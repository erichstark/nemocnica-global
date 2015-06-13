package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.api.domain.OfficeWrapper;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.service.*;

@RestController
@RequestMapping("/ws/office")
public class OfficeApi {

    @Autowired
    OfficeService officeService;
    @Autowired
    FacilityService facilityService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    InsuranceService insuranceService;
    @Autowired
    SpecializationService specializationService;

    @RequestMapping(method = RequestMethod.POST)
    public Long saveOffice(@RequestBody OfficeWrapper officeWrapper) {
        Office o = officeWrapper.build(officeService,facilityService,employeeService,insuranceService,specializationService);
        officeService.save(o);
        return o.getId();
    }

}
