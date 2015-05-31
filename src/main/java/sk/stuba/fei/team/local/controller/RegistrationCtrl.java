package sk.stuba.fei.team.local.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.stuba.fei.team.local.domain.Insurance;
import sk.stuba.fei.team.local.domain.Patient;
import sk.stuba.fei.team.local.service.PatientService;

import java.util.Map;

/**
 * Created by Erich on 07/05/15.
 */

@Controller
public class RegistrationCtrl {

	@Autowired
	PatientService patientService;

	@RequestMapping("/registration")
	public String index(Map<String, Object> model) {
		model.put("patient", new Patient());
		model.put("pageTitle", "Registrácia");
		return "registration";
	}

	// TODO check if email exist in DB

	// TODO insurance to string

	// TODO type of user from registration form

	@RequestMapping(value = "/registration/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("patient") Patient patient, Map<String, Object> model) {

		patientService.save(patient);

		return "redirect:/";
	}
}
