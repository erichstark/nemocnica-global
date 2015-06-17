package sk.stuba.fei.team.global.controller.patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.service.PatientService;

import java.util.Map;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private MessageSource messageSource;

    // zobrazenie mojho profilu - username tahaj z prihlaseneho usera
    @RequestMapping("/detail/{username}")
    public String index(@PathVariable String username,Map<String, Object> model) {

        Patient patient= patientService.findByUsername(username);
        model.put("patient",patient);

        return "order/index";
    }

    // save udajov
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String saveDetail(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message",messageSource.getMessage("save_success", null, LocaleContextHolder.getLocale()));
        return "redirect:/detail/" + patient.getUsername();
    }
}
