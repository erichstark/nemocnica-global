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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String edit(@RequestParam("name") String name, @PathVariable Long id) {

        Specialization sp = specializationService.findOne(id);
        sp.setName(name);
        specializationService.save(sp);

        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name) {

        Specialization sp = new Specialization(name);
        specializationService.save(sp);

        return "redirect:/admin/specialization";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {

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