package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Facility;
import sk.stuba.fei.team.global.service.FacilityService;

import java.util.Map;

@Controller
@RequestMapping("/admin/facility")
public class AdminFacilityController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", messageSource.getMessage("facilities",null, LocaleContextHolder.getLocale()));
        model.put("facilities", facilityService.findAll());

        return "admin/facility/index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Facility> facilities = facilityService.findByName(text);

        model.put("pageTitle", messageSource.getMessage("facilities",null, LocaleContextHolder.getLocale()));
        model.put("search", text);
        model.put("facilities", facilities);

        return "admin/facility/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", messageSource.getMessage("facilities",null, LocaleContextHolder.getLocale()));
        model.put("facilities", facilityService.findAll());

        return "admin/facility/index";
    }
}
