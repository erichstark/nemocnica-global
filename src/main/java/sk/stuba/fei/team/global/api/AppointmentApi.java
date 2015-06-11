package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.global.api.domain.AppointmentWrapper;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.service.AppointmentService;
import sk.stuba.fei.team.global.service.OfficeService;
import sk.stuba.fei.team.global.service.PatientService;

@RestController
@RequestMapping("/ws/appointment")
public class AppointmentApi {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientService patientService;
    @Autowired
    OfficeService officeService;

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public List<AppointmentWrapper> update(@RequestBody UpdateWrapper<Long> wrapper) {
//        
//    }

    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody AppointmentWrapper aw) {
        Appointment a = aw.build(patientService,officeService);
        appointmentService.save(a);
        return a.getId();
    }

}
