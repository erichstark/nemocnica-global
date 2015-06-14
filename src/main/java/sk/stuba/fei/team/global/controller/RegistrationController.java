package sk.stuba.fei.team.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.VerificationToken;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.OnRegistrationCompleteEvent;
import sk.stuba.fei.team.global.service.PatientService;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
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
                                      BindingResult result, WebRequest request, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors",result.getAllErrors());
			return "redirect:/registration";
		}

		try {
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent
					(patient, new Locale("sk_SK"), appUrl));
		} catch (Exception me) {
            redirectAttributes.addFlashAttribute("errors", result.getAllErrors());
            return "redirect:/registration";
        }
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
        Patient patient = patientService.findByUsername(vtoken.getUsername());
		patient.setEnabled(true);
		patient.getAuthorities().add(new SimpleGrantedAuthority("USER"));
		patientService.save(patient);

        redirectAttributes.addFlashAttribute("message", "Úspešne aktivované");
		return "redirect:/login";
	}
}
