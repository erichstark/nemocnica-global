package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.api.domain.PatientWrapper;
import sk.stuba.fei.team.global.api.domain.UpdateWrapper;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/ws/patient")
public class PatientApi {

    @Autowired
    PatientService patientService;
    @Autowired
    InsuranceService insuranceService;

    @RequestMapping(value = "/find/{searchTerm}", method = RequestMethod.GET)
    public List<PatientWrapper> findBySurNameOrEmail(@PathVariable String searchTerm) {
        List<Patient> plist = patientService.findBySurNameOrEmail(searchTerm);
        List<PatientWrapper> pwl = new ArrayList<>(plist.size());
        plist.forEach(p -> pwl.add(new PatientWrapper(p)));
        return pwl;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public PatientWrapper findByUsername(@PathVariable String username) {
        Patient p = patientService.findByUsername(username);
        if ( p != null)
            return new PatientWrapper(p);
        else
            return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<PatientWrapper> update(@RequestBody UpdateWrapper<String> wrapper) {
        List<Patient> plist = patientService.findSelectedByTimestamp(wrapper.getTimestamp(), new HashSet<String>(wrapper.getIds()));
        List<PatientWrapper> pwl = new ArrayList<>(plist.size());
        plist.forEach(p -> pwl.add(new PatientWrapper(p)));
        return pwl;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody PatientWrapper patientWrapper) {
        Patient p = patientWrapper.build(patientService, insuranceService);
        patientService.save(p);
    }
}
