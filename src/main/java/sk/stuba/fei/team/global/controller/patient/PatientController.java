package sk.stuba.fei.team.global.controller.patient;


import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.security.CustomUser;
import sk.stuba.fei.team.global.security.PBKDF2WithHmacSHA1;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private InsuranceService insuranceService;

    // zobrazenie mojho profilu - username tahaj z prihlaseneho usera
    @RequestMapping("/detail")
    public String index(Map<String, Object> model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();

        CustomUser  userDetails = (CustomUser) principal;

        Patient patient= patientService.findByUsername(userDetails.getUsername());
        PatientForm form= new PatientForm();
        form.setFirstName(patient.getFirstName());
        form.setSurname(patient.getSurname());
        form.setEmail(patient.getEmail());

        form.setInsurance(patient.getInsurance().getId());
        form.setPhone(patient.getPhone());
        form.setPrefix_title(patient.getPrefix_title());
        form.setSuffix_title(patient.getSuffix_title());



        List<Insurance> insurances = (List<Insurance>) insuranceService.findAll();
        model.put("insurances",insurances);
        model.put("patient",form);
        model.put("pageTitle","Môj profil");
        return "patient/index";
    }

    @RequestMapping("/password")
    public String password(Map<String, Object> model) {

        model.put("pageTitle","Zmena hesla");
        return "patient/password";
    }

    // save udajov
    @RequestMapping(value = "/detail/save", method = RequestMethod.POST)
    public String saveDetail(@ModelAttribute("patient") PatientForm form, RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUser  userDetails = (CustomUser) principal;

        Insurance insurance=insuranceService.findOne(form.getInsurance());
        Patient patient= patientService.findByUsername(userDetails.getUsername());
        patient.setFirstName(form.getFirstName());
        patient.setSurname(form.getSurname());
        patient.setEmail(form.getEmail());
        patient.setInsurance(insurance);
        patient.setPhone(form.getPhone());
        patient.setPrefix_title(form.getPrefix_title());
        patient.setSuffix_title(form.getSuffix_title());

        patientService.save(patient);

        redirectAttributes.addFlashAttribute("message",messageSource.getMessage("save_success", null, LocaleContextHolder.getLocale()));

        return "redirect:/patient/detail";
    }

    @RequestMapping(value = "/password/new", method = RequestMethod.POST)
    public String newPassword(@ModelAttribute("password") NewPassword form, RedirectAttributes redirectAttributes) {

        PBKDF2WithHmacSHA1 h = new PBKDF2WithHmacSHA1();



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUser  userDetails = (CustomUser) principal;
        Patient patient= patientService.findByUsername(userDetails.getUsername());

        if(h.matches(form.getOldPassword(),patient.getPassword())){

            if(form.getNewPasswordAgain().equals(form.getNewPassword())){
                patient.setPassword(h.encode(form.getNewPassword()));

                redirectAttributes.addFlashAttribute("message", messageSource.getMessage("new_password", null, LocaleContextHolder.getLocale()));

                return "redirect:/patient/detail";
            }else{
                redirectAttributes.addFlashAttribute("error","Nové heslo sa nezhoduje s opakovaným");

                return "redirect:/patient/password";

            }
        }
        redirectAttributes.addFlashAttribute("error",messageSource.getMessage("wrong_old_password", null, LocaleContextHolder.getLocale()));

        return "redirect:/patient/password";

    }
}
