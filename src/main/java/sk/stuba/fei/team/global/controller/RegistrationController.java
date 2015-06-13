package sk.stuba.fei.team.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.VerificationToken;
import sk.stuba.fei.team.global.service.InsuranceService;
import sk.stuba.fei.team.global.service.OnRegistrationCompleteEvent;
import sk.stuba.fei.team.global.service.PatientService;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

@Controller
public class RegistrationController {

	@Autowired
	PatientService patientService;
	@Autowired
	InsuranceService insuranceService;

	@RequestMapping("/registration")
	public String index(Map<String, Object> model) {
		model.put("patient", new Patient());
		model.put("insurances", insuranceService.findAllEnabled());
		model.put("pageTitle", "Registrácia");
		return "registration";
	}

	// TODO check if email exist in DB

	// TODO type of user from registration form

//	@RequestMapping(value = "/registration/save", method = RequestMethod.POST)
//	public String save(@ModelAttribute("patient") Patient patient, Map<String, Object> model) {
//
//		patientService.save(patient);
//
//		return "redirect:/";
//	}

	@Autowired
	ApplicationEventPublisher eventPublisher;

	@RequestMapping(value = "/registration/save", method = RequestMethod.POST)
	public String registerUserAccount(@ModelAttribute("patient") @Valid Patient patient,
											BindingResult result, WebRequest request, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}

		Patient registered = patientService.saveAndReturn(patient);
		try {
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent
					(registered, request.getLocale(), appUrl));
		} catch (Exception me) {
			result.addError(new ObjectError("unexpectederror",me.getMessage()));
			return "registration";
		}
		model.addAttribute("message","Úspešne zaregistrovaný, aktivujte si svoje konto aktivačným kódom doručeným na e-mail.");
		return "redirect:/";
	}

	@RequestMapping(value = "/registration/confirm", method = RequestMethod.GET)
	public String confirmRegistration
			(WebRequest request, Model model, @RequestParam("token") String token) {
		Locale locale = request.getLocale();

		VerificationToken verificationToken = patientService.getVerificationToken(token);
		if (verificationToken == null) {
			model.addAttribute("message", "Zlý verifikačný token");
			return "redirect:/";
		}

		Patient patient = verificationToken.getPatient();
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			model.addAttribute("message", "Verifikačný token expiroval");
			return "redirect:/";
		}

		patient.setEnabled(true);
		patientService.save(patient);
		return "redirect:/login";
	}
}
