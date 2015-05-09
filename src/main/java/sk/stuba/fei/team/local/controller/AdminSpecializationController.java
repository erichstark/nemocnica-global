package sk.stuba.fei.team.local.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Specialization;
import sk.stuba.fei.team.local.service.SpecializationService;

import java.util.Map;

/**
 * Created by pallo on 5/7/15.
 */
@Controller
@RequestMapping("/admin/specialization")
public class AdminSpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Specializations");
        model.put("specializations", specializationService.findAll());

        return "admin/specialization/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Specializations");
        model.put("specialization", new Specialization());

        return "admin/specialization/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Admin Specializations");
        model.put("specialization", specializationService.findOne(id));

        return "admin/specialization/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("specialization") Specialization specialization, Map<String, Object> model) {

        specializationService.save(specialization);

        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> model) {

        specializationService.delete(id);

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