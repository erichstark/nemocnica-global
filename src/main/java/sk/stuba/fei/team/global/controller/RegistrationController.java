package sk.stuba.fei.team.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.VerificationToken;
import sk.stuba.fei.team.global.security.PBKDF2WithHmacSHA1;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.OnRegistrationCompleteEvent;
import sk.stuba.fei.team.global.service.PatientService;

import javax.servlet.ServletRequest;
import javax.validation.Valid;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class RegistrationController {

    @Autowired
    PatientService patientService;
    @Autowired
    InsuranceService insuranceService;

    public static final Logger LOGGER = Logger.getLogger(RegistrationController.class.getName());

    @RequestMapping("/registration")
    public String index(Map<String, Object> model) {
        model.put("patient", new Patient());
        model.put("insurances", insuranceService.findAllEnabled());
        model.put("pageTitle", "Registrácia");
        return "registration";
    }

    // TODO check if email exist in DB

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("patient") @Valid Patient patient,
                                      BindingResult result, WebRequest webRequest, ServletRequest servletRequest, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors",result.getAllErrors());
            return "redirect:/registration";
        }
        PasswordEncoder encoder = new PBKDF2WithHmacSHA1();
        patient.setPassword(encoder.encode(patient.getPassword()));
        try {
            patientService.save(patient);
        } catch (Exception e) {
            List<ObjectError> oes = new ArrayList<>();
            oes.add(new ObjectError("Chyba aplikácie","Databázová chyba"));
            redirectAttributes.addFlashAttribute("errors", oes);
            return "redirect:/registration";
        }
        String appUrl = servletRequest.getServerName() + ":" + servletRequest.getServerPort() + servletRequest.getServletContext().getContextPath();
        // locale je nevyuzita
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent
                (patient, new Locale("sk_SK"), appUrl));

        redirectAttributes.addFlashAttribute("message", "Úspešne zaregistrovaný, aktivujte si svoje konto aktivačným kódom doručeným na e-mail.");
        return "redirect:/";
    }

    @RequestMapping(value = "/registration/confirm", method = RequestMethod.GET)
    @Transactional
    public String confirmRegistration
            (WebRequest request, RedirectAttributes redirectAttributes, @RequestParam("token") String token) {
//		Locale locale = request.getLocale();

        VerificationToken verificationToken = patientService.getVerificationToken(token);
        if (verificationToken == null) {
            redirectAttributes.addFlashAttribute("error", "Zlý verifikačný token");
            return "redirect:/";
        }

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            redirectAttributes.addFlashAttribute("error", "Verifikačný token expiroval");
            return "redirect:/";
        }

        VerificationToken vtoken = patientService.getVerificationToken(token);
        Patient patient = vtoken.getPatient();
        patient.setEnabled(true);
        patientService.save(patient);

        redirectAttributes.addFlashAttribute("message", "Úspešne aktivované");
        return "redirect:/login";
    }
}
