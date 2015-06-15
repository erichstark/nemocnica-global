package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/admin/patient")
public class AdminPatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", messageSource.getMessage("patients",null, LocaleContextHolder.getLocale()));
        model.put("patients", patientService.findAll());

        return "admin/patient/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", messageSource.getMessage("patient.add",null, LocaleContextHolder.getLocale()));
        model.put("patient", new Patient());
        model.put("insurances", insuranceService.findAll());

        return "admin/patient/add";
    }

    @RequestMapping(value = "/edit/{username}")
    public String edit(@PathVariable String username, Map<String, Object> model) {

        model.put("pageTitle", messageSource.getMessage("patient.edit",null, LocaleContextHolder.getLocale()));
        Patient p = patientService.findOne(username);
        ArrayList<Insurance> ins = (ArrayList) insuranceService.findAll();
        if(ins.contains(p.getInsurance())) ins.remove(p.getInsurance());
        model.put("patient", p);
        model.put("insurances", ins);

        return "admin/patient/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("patient") Patient patient, @RequestParam(required = false) Long id_insurance, RedirectAttributes redirectAttributes) {
        Patient old = patientService.findOne(patient.getUsername());

        if (id_insurance != null)
            patient.setInsurance(insuranceService.findOne(id_insurance));
        else
            patient.setInsurance(null);
        if(old !=null) {
            patient.setAuthorities(old.getAuthorities());
            patient.setAppointments(old.getAppointments());
        }

        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("save_success", null, LocaleContextHolder.getLocale()));
        patientService.save(patient);

        return "redirect:/admin/patient";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Patient> patients = patientService.findPatientByUsernameOrFirstOrSurname(text);

        model.put("pageTitle", messageSource.getMessage("patients",null, LocaleContextHolder.getLocale()));
        model.put("search", text);
        model.put("patients", patients);

        return "admin/patient/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", messageSource.getMessage("patients",null, LocaleContextHolder.getLocale()));
        model.put("patients", patientService.findAll());

        return "admin/patient/index";
    }
}
