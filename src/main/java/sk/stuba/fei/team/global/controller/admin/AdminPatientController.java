package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pallo on 5/7/15.
 */
@Controller
@RequestMapping("/admin/patient")
public class AdminPatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Patients");
        model.put("patients", patientService.findAll());

        return "admin/patient/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        model.put("pageTitle", "Admin Patients");
        model.put("patient", new Patient(authorities));
        model.put("insurances", insuranceService.findAll());

        return "admin/patient/add";
    }

    @RequestMapping(value = "/edit/{username}")
    public String edit(@PathVariable String username, Map<String, Object> model) {

        model.put("pageTitle", "Admin Patients");
        Patient p = patientService.findByUsername(username);
        ArrayList<Insurance> ins = (ArrayList) insuranceService.findAll();
        if(ins.contains(p.getInsurance())) ins.remove(p.getInsurance());
        model.put("patient", p);
        model.put("insurances", ins);

        return "admin/patient/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAdd(@ModelAttribute("patient") Patient patient, @RequestParam Long id_insurance) {
        Patient old = patientService.findByUsername(patient.getUsername());
        if (id_insurance != null)
            patient.setInsurance(insuranceService.findOne(id_insurance));
        else
            patient.setInsurance(null);
        patient.setAuthorities(old.getAuthorities());
        patient.setAppointments(old.getAppointments());
        patientService.save(patient);

        return "redirect:/admin/patient";
    }

    @RequestMapping(value = "/delete/{username}")
    public String delete(@PathVariable String username) {

        patientService.delete(username);

        return "redirect:/admin/patient";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Patient> patients = patientService.findPatientByUsernameOrFirstOrSurname(text);

        model.put("pageTitle", "Admin Patients");
        model.put("search", text);
        model.put("patients", patients);

        return "admin/patient/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Patients");
        model.put("patients", patientService.findAll());

        return "admin/patient/index";
    }
}
