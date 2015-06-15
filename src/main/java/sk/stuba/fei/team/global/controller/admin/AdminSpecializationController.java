package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Specialization;
import sk.stuba.fei.team.global.service.SpecializationService;

import java.util.Map;

/**
 * Created by pallo on 5/7/15.
 */
@Controller
@RequestMapping("/admin/specialization")
public class AdminSpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Specializations");
        model.put("specializations", specializationService.findAll());

        return "admin/specialization/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String edit(@RequestParam String name, @PathVariable Long id) {

        Specialization sp = specializationService.findOne(id);
        sp.setName(name);
        specializationService.save(sp);

        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/{id}/enabled", method = RequestMethod.POST)
    public @ResponseBody boolean changeEnabled(@RequestParam Boolean enabled, @PathVariable Long id) {
        Specialization s = specializationService.findOne(id);
        s.setEnabled(enabled);
        specializationService.save(s);
        return true;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Specialization specialization) {

        specialization.setEnabled(true);
        specializationService.save(specialization);

        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Specialization> offices = specializationService.findByName(text);

        model.put("pageTitle", "Admin Specializations");
        model.put("search", text);
        model.put("specializations", offices);

        return "admin/specialization/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Specializations");
        model.put("specializations", specializationService.findAll());

        return "admin/specialization/index";
    }

}