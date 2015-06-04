package sk.stuba.fei.team.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.security.PBKDF2WithHmacSHA1;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.*;

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

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Patients");
        model.put("patients", patientService.findAll());

        return "admin/patient/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Patients");
        model.put("patient", new Patient());
        model.put("insurances", insuranceService.findAll());

        return "admin/patient/add";
    }

    @RequestMapping(value = "/edit/{username}")
    public String edit(@PathVariable String username, Map<String, Object> model) {

        model.put("pageTitle", "Admin Patients");
        model.put("patient", patientService.findByUsername(username));
        model.put("insurances", insuranceService.findAll());

        return "admin/patient/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAdd(@ModelAttribute("patient") Patient patient, @RequestParam String autority, @RequestParam Long id_insurance) {

        PasswordEncoder encoder = new PBKDF2WithHmacSHA1();
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(autority));
        patient.setPassword(encoder.encode(patient.getPassword()));
        patient.setAuthorities(authorities);
        patient.setInsurance(insuranceService.findOne(id_insurance));
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
