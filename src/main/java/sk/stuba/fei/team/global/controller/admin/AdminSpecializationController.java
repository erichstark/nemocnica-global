package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.SpecializationService;

import java.util.Map;

@Controller
@RequestMapping("/admin/specialization")
public class AdminSpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", messageSource.getMessage("specializations",null, LocaleContextHolder.getLocale()));
        model.put("specializations", specializationService.findAll());

        return "admin/specialization/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String edit(@RequestParam String name, @PathVariable Long id, RedirectAttributes redirectAttributes) {

        Specialization sp = specializationService.findOne(id);
        sp.setName(name);
        specializationService.save(sp);

        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("edit_success", null, LocaleContextHolder.getLocale()));
        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/{id}/enabled", method = RequestMethod.POST)
    public @ResponseBody boolean changeEnabled(@RequestParam Boolean enabled, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        Specialization s = specializationService.findOne(id);
        s.setEnabled(enabled);

        specializationService.save(s);
        return true;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Specialization specialization, RedirectAttributes redirectAttributes) {

        specialization.setEnabled(true);
        specializationService.save(specialization);

        redirectAttributes.addFlashAttribute("message", messageSource.getMessage("save_success", null, LocaleContextHolder.getLocale()));
        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Specialization> offices = specializationService.findByName(text);

        model.put("pageTitle", messageSource.getMessage("specializations",null, LocaleContextHolder.getLocale()));
        model.put("search", text);
        model.put("specializations", offices);

        return "admin/specialization/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", messageSource.getMessage("specializations",null, LocaleContextHolder.getLocale()));
        model.put("specializations", specializationService.findAll());

        return "admin/specialization/index";
    }

}